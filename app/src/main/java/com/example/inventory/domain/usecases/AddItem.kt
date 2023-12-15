package com.example.inventory.domain.usecases

import com.example.inventory.data.dataClasses.InvalidItemException
import com.example.inventory.data.dataClasses.Item
import com.example.inventory.domain.repository.ItemRepository


class AddItem(private val repository: ItemRepository) {

    @Throws(InvalidItemException::class)
    suspend operator fun invoke(item: Item) {
        require(item.price >= 0) { "Item price cannot be negative" }

        repository.insertFavItem(item)
    }
}
