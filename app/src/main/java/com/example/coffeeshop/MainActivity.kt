package com.example.coffeeshop

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import com.example.coffeeshop.views.AppNavigation.MyBottomAppBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CoffeeShopTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    MyBottomAppBar()
                }
            }
        }
    }
}
