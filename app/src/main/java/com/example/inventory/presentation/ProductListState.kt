package com.example.inventory.presentation

import com.example.inventory.data.dataClasses.Item

data class ProductListState(
    val isLoading: Boolean = false,
    val items: List<Item> = emptyList(),
    val error: String = ""
)