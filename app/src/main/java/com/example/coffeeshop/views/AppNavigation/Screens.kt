package com.example.coffeeshop.views.AppNavigation

sealed class Screens (val screens: String) {
    data object HomeView: Screens("home")
    data object CartView: Screens("cart")
    data object FavoriteView: Screens("favorite")
    data object SettingsView: Screens("settings")

    data object ProductDetailView: Screens("productDetail/{productId}?imageUrl={imageUrl}&name={name}")
}

