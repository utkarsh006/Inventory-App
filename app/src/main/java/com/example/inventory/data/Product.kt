package com.example.inventory.data

data class Product(
    val categories: List<Category>,
    val error: Any,
    val message: String,
    val status: Boolean
)