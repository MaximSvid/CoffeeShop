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
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.repositories.MockCoffeeRepo
import com.example.coffeeshop.ui.theme.BrownJC
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import com.example.coffeeshop.viewModels.CoffeeProductViewModel
import com.example.coffeeshop.views.HomeView.SubView.ImageSlider
import com.example.coffeeshop.views.HomeView.SubView.ProductCard

@Composable
fun Home(
    viewModel: CoffeeProductViewModel = androidx.lifecycle.viewmodel.compose.viewModel(
        factory = CoffeeProductViewModel(MockCoffeeRepo())
    )
) {

    val products by viewModel.products.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(5.dp))

            ImageSlider()

            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(8.dp),
                modifier = Modifier.fillMaxSize()
            ) {
                items(products) {product ->
                    Box (
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(8.dp)
                    ){
                        ProductCard(
                            painter = painterResource(
                                id = product.imageUrl.toDrawableResource()
                            ),
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
            Spacer(modifier = Modifier.height(16.dp))
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