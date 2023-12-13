package com.example.inventory.navigation

sealed class NavScreen(val route: String) {
    object StoreScreen : NavScreen("store_screen")
    object FavoritesScreen : NavScreen("favorites_screen")
    object CartScreen : NavScreen("cart_screen")

}