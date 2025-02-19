package com.example.coffeeshop.views.HomeView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshop.R
import com.example.coffeeshop.repositories.MockCoffeeRepo
import com.example.coffeeshop.ui.theme.BrownJC
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import com.example.coffeeshop.viewModels.CoffeeProductViewModel
import com.example.coffeeshop.views.AppNavigation.MyBottomAppBar
import com.example.coffeeshop.views.HomeView.SubView.ImageSlider
import com.example.coffeeshop.views.HomeView.SubView.ProductCard

@Composable
fun Home(
    navController: NavController = rememberNavController(),
    viewModel: CoffeeProductViewModel = hiltViewModel()
) {
    val products by viewModel.products.collectAsState(emptyList())



    LazyColumn(
        modifier = Modifier.fillMaxSize()
    ) {
        // Слайдер как отдельный item
        item {
            ImageSlider()
            Spacer(modifier = Modifier.height(20.dp))
        }
        //как между этими двумя элементами добавить padding 10 dp по горизнтали

        if (products.isEmpty()) {
            item {
                Text("product is empty yet")
            }
        } else {
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
}
