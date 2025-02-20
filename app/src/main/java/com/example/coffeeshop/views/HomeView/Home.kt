package com.example.coffeeshop.views.HomeView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshop.viewModels.CoffeeProductViewModel
import com.example.coffeeshop.views.HomeView.SubView.ImageSlider
import com.example.coffeeshop.views.HomeView.SubView.ProductCard
import com.example.coffeeshop.views.HomeView.SubView.Search

@Composable
fun Home(
    navController: NavController = rememberNavController(),
    viewModel: CoffeeProductViewModel = hiltViewModel()
) {
    val products by viewModel.products.collectAsState(emptyList())
    val searchState by viewModel.searchState.collectAsState()

    Column (modifier = Modifier.fillMaxSize()){
        Search(state = searchState, onStateChange = viewModel::updateSearchState,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp)
            )
    }

    LazyColumn(
        modifier = Modifier.fillMaxSize()
//        Spacer
    ) {

        // Слайдер как отдельный item
        item {
            ImageSlider()
            Spacer(modifier = Modifier.height(20.dp))
        }
        //как между этими двумя элементами добавить padding 10 dp по горизнтали

        // Сетка продуктов как chunks по 2 элемента
        items(products.chunked(2)) { rowProducts ->
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
                            .aspectRatio(1f)
//                            .padding(end = 12.dp)
                    )
                }
                // Если в последней строке только один элемент, добавляем пустое пространство
                if (rowProducts.size == 1) {
                    Spacer(modifier = Modifier.weight(1f))
                }
            }
        }
    }
}
