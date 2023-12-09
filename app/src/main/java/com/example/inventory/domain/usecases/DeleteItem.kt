package com.example.inventory.domain.usecases

import com.example.inventory.data.dataClasses.Item
import com.example.inventory.domain.repository.ItemRepository

class DeleteItem(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(item: Item) {
        repository.deleteItem(item)
    }
}