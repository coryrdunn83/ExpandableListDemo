package com.coryrdunn.myapplication.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.coryrdunn.myapplication.domain.models.Fruit

@Database(
    entities = [Fruit::class],
    version = 2
)

abstract class FruitDatabase: RoomDatabase() {

    abstract val fruitDao: FruitDao

    companion object {
        const val DATABASE_NAME = "fruit_database"
    }

}