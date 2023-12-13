package com.example.inventory.presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.inventory.R
import com.example.inventory.presentation.ProductListScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyStoreScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { TextComponent(value = "MyStore") },
                actions = {
                    IconButton(
                        onClick = {
                            // Handle favorites icon click
                        },
                        modifier = Modifier
                            .size(32.dp)
                            .padding(end = 8.dp) // Adjust the padding as needed
                    ) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_heart),
                            contentDescription = "Favorites"
                        )
                    }

                    IconButton(
                        onClick = {
                            // Handle cart icon click
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
        ProductListScreen(modifier = Modifier.padding(innerPadding))
    }
}
