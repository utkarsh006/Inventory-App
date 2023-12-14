package com.example.inventory.presentation

import com.example.inventory.data.dataClasses.Item

sealed class ProductsEvent {
    data class AddFavorite(val item: Item) : ProductsEvent()
    data class DeleteFavorite(val item: Item) : ProductsEvent()

}
