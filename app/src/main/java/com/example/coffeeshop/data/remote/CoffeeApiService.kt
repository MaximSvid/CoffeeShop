package com.example.coffeeshop.data.remote

import com.example.coffeeshop.data.model.Product
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://fake-coffee-api.vercel.app/api"

// TODO Moshi: Moshi ist eine Bibliothek zur JSON-Serialisierung und -Deserialisierung. KotlinJsonAdapterFactory wird verwendet, um Kotlin-Datenklassen zu unterstützen.
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

// Retrofit: Eine Bibliothek zum Erstellen von API-Clients. Hier wird sie mit Moshi für die JSON-Konvertierung und dem OkHttpClient für die Netzwerkanfragen konfiguriert.
private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

//retrofit - interface erstellen (diese interface beschreibt API- Anfrage)
interface CoffeeApiService {
    @GET(".")
    suspend fun getAllProducts(): List<Product>
}

object CoffeeApi {
    val retrofitService: CoffeeApiService by lazy { retrofit.create(CoffeeApiService::class.java) }
}