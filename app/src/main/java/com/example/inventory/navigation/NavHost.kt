package com.example.inventory.navigation

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.inventory.presentation.CartScreen
import com.example.inventory.presentation.FavoritesScreen
import com.example.inventory.presentation.components.MyStoreScreen


@Composable
fun AppNavHost() {
    Surface(color = MaterialTheme.colorScheme.background) {
        val navController = rememberNavController()
        NavHost(
            navController = navController,
            startDestination = NavScreen.StoreScreen.route
        ) {
            composable(route = NavScreen.StoreScreen.route) {
                MyStoreScreen(navController)
            }

            composable(
                route = NavScreen.FavoritesScreen.route
            ) {
                FavoritesScreen(navController = navController)
            }

            composable(
                route = NavScreen.CartScreen.route
            ) {
                CartScreen(navController = navController)
            }

        }
    }

}