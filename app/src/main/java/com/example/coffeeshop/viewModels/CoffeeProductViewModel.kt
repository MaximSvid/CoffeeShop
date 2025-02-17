package com.example.coffeeshop.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.repositories.CoffeeApiRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CoffeeProductViewModel @Inject constructor(
    private val repository: CoffeeApiRepository
) : ViewModel() {
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()

    init {
        viewModelScope.launch {
            try {
                fetchProducts()
            } catch (e: Exception) {
                Log.e("CoffeeProductViewModel", "Error initializing", e)
            }
        }
    }

    private suspend fun fetchProducts() {
        try {
            val productsList = repository.getAllProducts()
            _products.value = productsList
        } catch (e: Exception) {
            Log.e("CoffeeProductViewModel", "Error fetching products", e)
        }
    }
}
