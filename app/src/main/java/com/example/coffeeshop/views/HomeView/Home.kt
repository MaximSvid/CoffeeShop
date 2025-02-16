package com.example.coffeeshop.views.HomeView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.R
import com.example.coffeeshop.ui.theme.BrownJC
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import com.example.coffeeshop.views.HomeView.SubView.ImageSlider
import com.example.coffeeshop.views.HomeView.SubView.ProductCard

@Composable
fun Home() {
    Box(modifier = Modifier.fillMaxSize()) {
        Column (modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(5.dp))

            ImageSlider()

            val painter = painterResource(id = R.drawable.coffee2)
            val description = "Test description"
            val title = "Test title"
            val roastLevel = 3
            val price = 12.99

            Box (
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .padding(10.dp)
            ){
                ProductCard(
                    painter = painter,
                    contentDescription = description,
                    title = title,
                    roastLevel = roastLevel,
                    price = price,
                    onLikeClick = { /*TODO*/ },
                    modifier = Modifier
                )
            }



            Spacer(modifier = Modifier.height(16.dp))

        }
    }
}


@Preview
@Composable
fun ImageSliderPreview() {
    CoffeeShopTheme {
        Home()
    }
}