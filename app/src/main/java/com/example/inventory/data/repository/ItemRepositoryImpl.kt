package com.example.inventory.data.repository

import com.example.inventory.data.dataClasses.Item
import com.example.inventory.data.database.ItemDao
import com.example.inventory.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class ItemRepositoryImpl(
    private val dao: ItemDao
) : ItemRepository {
    override fun getItems(): Flow<List<Item>> {
        return dao.getItems()
    }

    override suspend fun getItemById(id: Int): Item? {
        return dao.getItemById(id)
    }

    override suspend fun insertItem(item: Item) {
        dao.insertItem(item)
    }

    override suspend fun deleteItem(item: Item) {
        dao.deleteItem(item)
    }
}
