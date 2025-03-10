package com.example.coffeeshop.views.HomeView

import android.net.Uri
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.coffeeshop.viewModels.CoffeeProductViewModel
import com.example.coffeeshop.views.HomeView.SubView.ImageSlider
import com.example.coffeeshop.views.HomeView.SubView.ProductCard
import com.example.coffeeshop.views.HomeView.SubView.Search

@Composable
fun Home(
    navController: NavController,
    viewModel: CoffeeProductViewModel = hiltViewModel()
) {
    val products by viewModel.products.collectAsState(emptyList())
    val searchState by viewModel.searchState.collectAsState()

    Column(modifier = Modifier.fillMaxSize()) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
        ) {
            Search(
                state = searchState,
                onStateChange = viewModel::updateSearchState,
                modifier = Modifier.fillMaxWidth()
            )
        }

        // Скроллируемый контент
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(top = 8.dp)
        ) {
            // Слайдер
            item {
                ImageSlider()
                Spacer(modifier = Modifier.height(20.dp))
            }

            // Сетка продуктов
            items(
                items = products.chunked(2),
                key = { rowProducts ->
                    rowProducts.map { it.id }.joinToString()
                }
            ) { rowProducts ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp, vertical = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    rowProducts.forEach { product ->
                        ProductCard(
                            imageUrl = product.imageUrl,
                            contentDescription = product.description,
                            title = product.name,
                            roastLevel = product.roastLevel.toString(),
                            price = product.price.toString(),
                            onLikeClick = { /*TODO*/ },
                            modifier = Modifier
                                .weight(1f)
                                .heightIn(min = 200.dp),  // Фиксированная минимальная высота
                            onClick = {
                                val route = "productDetail/${product.id}" +
                                        "?imageUrl=${Uri.encode(product.imageUrl)}" +
                                        "&name=${Uri.encode(product.name)}" +
                                        "&productDescription=${Uri.encode(product.description)}" +
                                        "&price=${product.price}" +
                                        "&region=${Uri.encode(product.region)}" +
                                        "&roastLevel=${product.roastLevel}"
                                Log.d("Navigation", "Navigating to: $route")
                                navController.navigate(route)
                            }
                        )
                    }
                    if (rowProducts.size == 1) {
                        Spacer(modifier = Modifier.weight(1f))
                    }
                }
            }
        }
    }
}

