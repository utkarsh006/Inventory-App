package com.example.inventory.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.inventory.R
import com.example.inventory.navigation.NavScreen
import com.example.inventory.presentation.ProductListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyStoreScreen(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TextComponent(value = "MyStore") },
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate(NavScreen.FavoritesScreen.route)
                        },
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = "Favorites"
                        )
                    }

                    IconButton(
                        onClick = {
                            navController.navigate(NavScreen.CartScreen.route)
                        },
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 8.dp)
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_cart),
                            contentDescription = "Shopping Cart"
                        )
                    }
                }
            )
        }
    ) { innerPadding ->
        ProductListScreen(
            navController = rememberNavController(),
            modifier = Modifier.padding(innerPadding)
        )
    }
}
