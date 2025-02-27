package com.example.coffeeshop.data.remote

import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.repositories.CoffeeApiRepo.CoffeeApiRepository
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import javax.inject.Inject
import javax.inject.Singleton
const val BASE_URL = "https://fake-coffee-api.vercel.app/api/"

// Интерфейс API сервиса
interface CoffeeApiService {
    @GET(".")
    suspend fun getAllProducts(): List<Product>
}

// Repository Implementation с Hilt
@Singleton
class CoffeeApiRepoImplementation @Inject constructor(
    private val apiService: CoffeeApiService
): CoffeeApiRepository {
    override suspend fun getAllProducts(): List<Product> {
        return apiService.getAllProducts()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    fun provideBaseUrl(): String = BASE_URL

    @Singleton
    @Provides
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .add(KotlinJsonAdapterFactory())
            .build()
    }

    @Singleton
    @Provides
    fun provideMoshiConverterFactory(moshi: Moshi): MoshiConverterFactory {
        return MoshiConverterFactory.create(moshi)
    }

    @Singleton
    @Provides
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        moshiConverterFactory: MoshiConverterFactory,
        baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(moshiConverterFactory)
            .build()
    }

    @Singleton
    @Provides
    fun provideCoffeeApiService(retrofit: Retrofit): CoffeeApiService {
        return retrofit.create(CoffeeApiService::class.java)
    }

    @Singleton
    @Provides
    fun provideCoffeeRepository(
        coffeeApiService: CoffeeApiService
    ): CoffeeApiRepository {
        return CoffeeApiRepoImplementation(coffeeApiService)
    }
}