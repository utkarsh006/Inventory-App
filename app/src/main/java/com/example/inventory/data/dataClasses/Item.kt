package com.example.inventory.data.dataClasses

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    val icon: String,
    @PrimaryKey
    val id: Int,
    val name: String,
    val price: Double
)