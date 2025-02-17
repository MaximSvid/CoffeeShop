package com.example.coffeeshop.repositories

import android.util.Log
import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.data.remote.CoffeeApiService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CoffeeApiRepoImplementation @Inject constructor(
    private val apiService: CoffeeApiService
): CoffeeApiRepository {
    override suspend fun getAllProducts(): List<Product> {
        return try {
            apiService.getAllProducts()
        } catch (e: Exception) {
            Log.e("CoffeeApiRepo", "Error fetching products", e)
            emptyList()
        }
    }
}