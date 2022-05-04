package com.example.fishapp.data

import android.app.Application
import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.fishapp.domain.FishItem

@Database(entities = [FishItem::class], version = 2, exportSchema = false)
@TypeConverters(FishTypeConverter::class)
abstract class FavouriteFishDatabase: RoomDatabase() {
    companion object {
        private val LOCK = Any()
        private const val DB_NAME = "fishies.db"
        private var databaseFavourite: FavouriteFishDatabase? = null

        fun getInstance(context: Context): FavouriteFishDatabase {
            synchronized(LOCK) {
                if (databaseFavourite==null) {
                    val instance = Room.databaseBuilder(context, FavouriteFishDatabase::class.java, DB_NAME)
                        .fallbackToDestructiveMigration()
                        .build()
                    databaseFavourite = instance
                    return instance
                }  else {
                    return databaseFavourite as FavouriteFishDatabase
                }
            }
        }
    }
    abstract fun fishDao(): FishDao
}