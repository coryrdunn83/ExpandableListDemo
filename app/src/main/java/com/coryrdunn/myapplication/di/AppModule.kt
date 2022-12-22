package com.coryrdunn.myapplication.di

import android.app.Application
import androidx.room.Room
import com.coryrdunn.myapplication.data.data_source.FruitDatabase
import com.coryrdunn.myapplication.data.repository.FruitRepositoryImpl
import com.coryrdunn.myapplication.domain.repository.FruitRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun providesFruitDatabase(app: Application): FruitDatabase {
        return Room.databaseBuilder(
            app,
            FruitDatabase::class.java,
            FruitDatabase.DATABASE_NAME
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesFruitRepository(database: FruitDatabase): FruitRepository {
        return FruitRepositoryImpl(database.fruitDao)
    }
}