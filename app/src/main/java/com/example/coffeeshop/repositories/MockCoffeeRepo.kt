package com.example.coffeeshop.repositories

import com.example.coffeeshop.R
import com.example.coffeeshop.data.model.Product

class MockCoffeeRepo: CoffeeApiRepository {
    override suspend fun getAllProducts(): List<Product> {
        return listOf(
            Product(
                id = 1,
                name = "Signature Blend",
                description = "A rich, full-bodied coffee...",
                price = 12.99,
                region = "Central America",
                weight = 500,
                flavorProfile = listOf("Dark Chocolate", "Black Cherry"),
                grindOptions = listOf("Whole Bean", "Espresso"),
                roastLevel = 3,
                imageUrl = "coffee1"
            ),
            Product(
                id = 2,
                name = "Golden Sunrise",
                description = "A smooth and bright coffee...",
                price = 10.99,
                region = "Africa",
                weight = 500,
                flavorProfile = listOf("Citrus"),
                grindOptions = listOf("Whole Bean", "Filter"),
                roastLevel = 2,
                imageUrl = "coffee2"
            )
        )
    }
}