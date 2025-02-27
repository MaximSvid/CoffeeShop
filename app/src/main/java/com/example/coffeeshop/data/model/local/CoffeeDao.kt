package com.example.coffeeshop.data.model.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.coffeeshop.data.model.localDatabaseRoom.FavoriteProduct
import kotlinx.coroutines.flow.Flow

@Dao
interface CoffeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertToFavoriteProduct(favoriteProduct: FavoriteProduct)

    @Delete
    suspend fun deleteFromFavoriteProduct(favoriteProduct: FavoriteProduct)

    @Query ("SELECT * FROM FavoriteProduct")
    suspend fun getAllFavoriteProducts(): Flow<List<FavoriteProduct>>

}