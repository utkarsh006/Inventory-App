package com.example.inventory.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.example.inventory.R
import com.example.inventory.data.dataClasses.Item
import com.example.inventory.presentation.ProductListViewModel
import com.example.inventory.presentation.ProductsEvent
import kotlinx.coroutines.launch

@Composable
fun CardComponent(
    item: Item,
    viewModel: ProductListViewModel = hiltViewModel()
) {
    var isAddToCartClicked by remember { mutableStateOf(false) }
    var isFavorite by remember { mutableStateOf(viewModel.isFavorite(item.id)) }
    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .clip(RoundedCornerShape(8.dp))
            .width(250.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(end = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconComponent(
                    iconResId = R.drawable.ic_heart,
                    tint = Color.Black,
                    onClick = {
                        isFavorite = !isFavorite
                        viewModel.onEvent(
                            if (isFavorite) ProductsEvent.DeleteFavorite(item)
                            else ProductsEvent.AddFavorite(item)
                        )

                        scope.launch {
                            snackbarHostState.showSnackbar(
                                if (isFavorite) "Item removed from favorites"
                                else "Item added to favorites"
                            )
                        }
                    }
                )

            }

            Spacer(modifier = Modifier.height(8.dp))

            AsyncImage(
                model = item.icon,
                contentDescription = "",
                modifier = Modifier
                    .wrapContentWidth()
                    .height(80.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            TextComponent(value = item.name)

            Spacer(modifier = Modifier.height(5.dp))

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Start
            ) {
                TextComponent(value = item.price)
                Spacer(modifier = Modifier.weight(1f))
                IconComponent(
                    iconResId = if (isAddToCartClicked) R.drawable.ic_check else R.drawable.ic_add,
                    tint = if (isAddToCartClicked) Color.Gray else Color.Green,
                    onClick = {
                        if (!isAddToCartClicked) {
                            isAddToCartClicked = true
                            scope.launch {
                                snackbarHostState.showSnackbar("Item added to cart")
                            }
                        }
                    }
                )
            }
        }
    }
}

@Preview
@Composable
fun MyPreview() {
    CardComponent(
        item = Item(
            "https://cdn-icons-png.flaticon.com/128/2553/2553691.png",
            1,
            "Chips",
            20.00
        )
    )
}