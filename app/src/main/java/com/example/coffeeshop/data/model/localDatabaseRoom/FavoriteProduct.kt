package com.example.coffeeshop.data.model.localDatabaseRoom

import androidx.compose.ui.text.font.FontWeight
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class FavoriteProduct (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val description: String,
    val price: Double,
    val region: String,
    val weight: String,
    val roastLevel: Int,
    val imageUrl: String,
    val isFavorite: Boolean = false
)