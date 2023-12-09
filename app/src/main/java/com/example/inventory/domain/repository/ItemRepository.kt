package com.example.inventory.domain.repository

import com.example.inventory.data.dataClasses.Item
import kotlinx.coroutines.flow.Flow

//we declared an interface for repository, so as to make testing easier
interface ItemRepository {

    fun getItems() : Flow<List<Item>>

    suspend fun getItemById(id:Int) : Item?

    suspend fun insertItem(item: Item)

    suspend fun deleteItem(item: Item)
}