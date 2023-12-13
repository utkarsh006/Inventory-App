package com.example.inventory.domain.repository

import com.example.inventory.data.dataClasses.Item
import kotlinx.coroutines.flow.Flow

interface ItemRepository {

    fun getItems() : Flow<List<Item>>

    suspend fun getItemById(id:Int) : Item?

    suspend fun insertFavItem(item: Item)

    suspend fun deleteItem(item: Item)
}