package com.example.inventory.presentation

import com.example.inventory.data.dataClasses.Item

sealed class ProductsEvent {
    data class ToggleFavorite(val item: Item) : ProductsEvent()

}
