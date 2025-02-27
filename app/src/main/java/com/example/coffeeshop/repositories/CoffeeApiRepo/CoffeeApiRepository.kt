package com.example.coffeeshop.repositories.CoffeeApiRepo

import com.example.coffeeshop.data.model.Product

interface CoffeeApiRepository {
    suspend fun getAllProducts(): List<Product>
}