package com.example.inventory.presentation

import com.example.inventory.data.dataClasses.Item
import com.example.inventory.utils.JSONParser

data class ProductListState(
    val isLoading: Boolean = false,
    val items: List<Item> = JSONParser.getObject(),
    val error: String = ""
)