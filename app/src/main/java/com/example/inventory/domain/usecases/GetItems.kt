package com.example.inventory.domain.usecases

import com.example.inventory.data.dataClasses.Item
import com.example.inventory.domain.repository.ItemRepository
import kotlinx.coroutines.flow.Flow

class GetItems(private val repository: ItemRepository) {

    fun invoke(): Flow<List<Item>> {
        return repository.getItems()
    }
}
