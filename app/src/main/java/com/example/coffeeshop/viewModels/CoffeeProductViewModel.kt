package com.example.coffeeshop.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coffeeshop.data.enumClass.SortType
import com.example.coffeeshop.data.model.Product
import com.example.coffeeshop.data.model.SearchState
import com.example.coffeeshop.repositories.CoffeeApiRepo.CoffeeApiRepository
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

    private val _searchState = MutableStateFlow(SearchState())
    val searchState = _searchState.asStateFlow()

    fun updateSearchState(newState: SearchState) {
        _searchState.value = newState
        viewModelScope.launch {
            try {
                val originalProducts = repository.getAllProducts()
                filterProducts(originalProducts)
            } catch (e: Exception) {
                Log.e("CoffeeProductViewModel", "Error updating search state", e)
            }
        }
    }

    private fun filterProducts(originalProducts: List<Product>) {
        val filtered = originalProducts
            .filter { product ->
                product.name.contains(searchState.value.searchText, ignoreCase = true) ||
                        product.description.contains(searchState.value.searchText, ignoreCase = true)
            }
            .let { filteredList ->
                when (searchState.value.sortType) {
                    SortType.NAME_ASC -> filteredList.sortedBy { it.name }
                    SortType.NAME_DESC -> filteredList.sortedByDescending { it.name }
                    SortType.PRICE_ASC -> filteredList.sortedBy { it.price }
                    SortType.PRICE_DESC -> filteredList.sortedByDescending { it.price }
                }
            }
        _products.value = filtered
    }
}
