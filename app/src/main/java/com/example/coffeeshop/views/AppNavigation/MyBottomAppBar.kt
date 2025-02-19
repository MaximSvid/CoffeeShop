package com.example.coffeeshop.views.AppNavigation

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.coffeeshop.ui.theme.BrownJC
import com.example.coffeeshop.ui.theme.CoffeeShopTheme
import com.example.coffeeshop.views.Cart
import com.example.coffeeshop.views.Favorite
import com.example.coffeeshop.views.HomeView.Home
import com.example.coffeeshop.views.Settings

@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }

    Scaffold (
        bottomBar = {
            BottomAppBar (
                containerColor = BrownJC
            ) {
                IconButton(onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.HomeView.screens) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Home, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                    )
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.ShoppingCart
                    navigationController.navigate(Screens.CartView.screens) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.ShoppingCart, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.ShoppingCart) Color.White else Color.DarkGray
                    )
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Favorite
                    navigationController.navigate(Screens.FavoriteView.screens) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Favorite, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Favorite) Color.White else Color.DarkGray
                    )
                }

                IconButton(onClick = {
                    selected.value = Icons.Default.Settings
                    navigationController.navigate(Screens.SettingsView.screens) {
                        popUpTo(0)
                    }
                },
                    modifier = Modifier.weight(1f)
                ) {
                    Icon(
                        Icons.Default.Settings, contentDescription = null, modifier = Modifier.size(26.dp),
                        tint = if (selected.value == Icons.Default.Settings) Color.White else Color.DarkGray
                    )
                }
            }
        }
    ) {paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.HomeView.screens,
            modifier = Modifier.padding(paddingValues)
        )
        {
            composable(Screens.HomeView.screens) { Home(navController = navigationController) }
            composable(Screens.CartView.screens) { Cart() }
            composable(Screens.FavoriteView.screens) { Favorite() }
            composable(Screens.SettingsView.screens) { Settings() }
        }
    }
}
@Preview
@Composable
fun MyBottomBarPreview() {
    CoffeeShopTheme {
        MyBottomAppBar()
    }
}