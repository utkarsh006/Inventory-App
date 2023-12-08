package com.example.inventory.data

data class Category(
    val id: Int,
    val items: List<Item>,
    val name: String
)