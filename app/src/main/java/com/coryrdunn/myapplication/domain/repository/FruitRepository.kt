package com.coryrdunn.myapplication.domain.repository

import com.coryrdunn.myapplication.domain.models.Fruit
import kotlinx.coroutines.flow.Flow

interface FruitRepository {

    fun getFruit(): Flow<List<Fruit>>
    suspend fun addFruit(fruit: Fruit)
}