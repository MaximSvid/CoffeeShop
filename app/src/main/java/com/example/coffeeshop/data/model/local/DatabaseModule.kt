package com.example.coffeeshop.data.model.local

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideCoffeeDatabase(@ApplicationContext context: Context): FavoriteProductDatabase {
        return Room.databaseBuilder(
            context,
            FavoriteProductDatabase::class.java,
            "coffee_database"
        )
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun provideCoffeeDao(database: FavoriteProductDatabase): CoffeeDao {
        return database.coffeeDao()
    }
}