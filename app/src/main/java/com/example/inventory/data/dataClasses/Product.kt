package com.example.inventory.data.dataClasses

data class Product(
    val categories: List<Category>,
    val error: Any,
    val message: String,
    val status: Boolean
)