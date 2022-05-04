package com.example.fishapp.data

import androidx.room.*
import com.example.fishapp.domain.FishItem

@Dao
interface FishDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFishToFav(fish: FishItem)

    @Delete
    suspend fun removeFishFromFav(fish: FishItem)

    @Query("SELECT EXISTS (SELECT 1 FROM fishitem WHERE name = :name)")
    suspend fun existsInFav(name: String?): Boolean

}