package com.example.coffeeshop.views.HomeView

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.coffeeshop.ui.theme.BrownJC
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import com.example.coffeeshop.views.HomeView.SubView.ImageSlider

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

            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "HomeView", fontSize = 30.sp, color = BrownJC )
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