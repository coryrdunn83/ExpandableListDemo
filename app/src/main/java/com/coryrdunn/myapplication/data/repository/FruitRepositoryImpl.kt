package com.coryrdunn.myapplication.data.repository

import com.coryrdunn.myapplication.data.data_source.FruitDao
import com.coryrdunn.myapplication.domain.models.Fruit
import com.coryrdunn.myapplication.domain.repository.FruitRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FruitRepositoryImpl @Inject constructor(
    private val dao: FruitDao
): FruitRepository {
    private val scope = CoroutineScope(Job() + Dispatchers.IO)

    init {
        scope.launch {
            val fruitList = listOf(
                Fruit(
                    name = "Apple",
                    color = "Red",
                    taste = "Crisp"
                ),
                Fruit(
                    name = "Orange",
                    color = "Orange",
                    taste = "Citrus"
                ),
                Fruit(
                    name = "Strawberry",
                    color = "Red",
                    taste = "Sweet"
                )
            )
            for (fruit in fruitList) {
                addFruit(fruit)
            }
        }
    }

    override fun getFruit(): Flow<List<Fruit>> {
        return dao.getFruit()
    }

    override suspend fun addFruit(fruit: Fruit) {
        return dao.addFruit(fruit)
    }
}