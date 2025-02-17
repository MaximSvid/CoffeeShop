package com.example.coffeeshop.viewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.repositories.CoffeeApiRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class CoffeeProductViewModel(private val repository: CoffeeApiRepository) : ViewModel(),
    ViewModelProvider.Factory {

    private val _products = MutableStateFlow<List<Product>>(emptyList())
    val products = _products.asStateFlow()
    fun fetchProducts() {
        viewModelScope.launch {
            try {
                _products.value = repository.getAllProducts()
            } catch (e: Exception) {
                println("FetchProducts error")
            }
        }
    }
}