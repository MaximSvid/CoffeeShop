package com.example.coffeeshop.data.model

import android.graphics.Region
import com.squareup.moshi.Json

data class Product(
    var id: Int,
    var name: String,
    var description: String,
    var price: Double,
    var region: String,
    var weight: Int,

    @Json(name = "flavor_profile") var flavorProfile: List<String>,
    @Json(name = "grind_option") var grindOptions: List<String>,
    @Json(name = "roast_level") var roastLevel: Int,
    @Json(name = "image_url") var imageUrl: String
)

