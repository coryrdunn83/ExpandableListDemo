package com.coryrdunn.myapplication.data.data_source

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.coryrdunn.myapplication.domain.models.Fruit
import kotlinx.coroutines.flow.Flow

@Dao
interface FruitDao {

    @Query("SELECT * FROM fruit")
    fun getFruit(): Flow<List<Fruit>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addFruit(fruit: Fruit)
}