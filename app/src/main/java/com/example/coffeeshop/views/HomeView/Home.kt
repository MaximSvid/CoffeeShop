package com.example.coffeeshop.views.HomeView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
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
        item {
            ImageSlider()
        }

        if (products.isEmpty()) {
            item {
                Text("Нет продуктов")
            }
            return@LazyColumn
        }

        item {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.height(300.dp) // Фиксированная высота для сетки
            ) {
                items(products) { product ->
                    ProductCard(
                        painter = painterResource(id = product.imageUrl.toDrawableResource()),
                        contentDescription = product.description,
                        title = product.name,
                        roastLevel = product.roastLevel,
                        price = product.price,
                        onLikeClick = { /*TODO*/ },
                        modifier = Modifier
                    )
                }
            }
        }
    }
}

fun String.toDrawableResource(): Int {
    return when(this) {
        "coffee1" -> R.drawable.coffee1
        "coffee2" -> R.drawable.coffee2
        else -> R.drawable.coffee1 // дефолтное изображение
    }
}

//
//@Preview
//@Composable
//fun ImageSliderPreview() {
//    CoffeeShopTheme {
//        Home()
//    }
//}