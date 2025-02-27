package com.example.coffeeshop.data.model.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.coffeeshop.data.model.localDatabaseRoom.FavoriteProduct

@Database(entities = [FavoriteProduct::class], version = 1, exportSchema = false)
abstract class FavoriteProductDatabase: RoomDatabase() {
    abstract fun coffeeDao(): CoffeeDao
}

