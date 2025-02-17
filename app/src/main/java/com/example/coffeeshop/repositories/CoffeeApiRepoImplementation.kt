package com.example.coffeeshop.repositories

import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.data.remote.CoffeeApiService

class CoffeeApiRepoImplementation(private val apiService: CoffeeApiService): CoffeeApiRepository {
    override suspend fun getAllProducts(): List<Product> {
        return  apiService.getAllProducts()
    }
}