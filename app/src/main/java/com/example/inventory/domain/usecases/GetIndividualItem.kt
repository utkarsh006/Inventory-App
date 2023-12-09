package com.example.inventory.domain.usecases

import com.example.inventory.data.dataClasses.Item
import com.example.inventory.domain.repository.ItemRepository


class GetIndividualItem(
    private val repository: ItemRepository
) {
    suspend operator fun invoke(id: Int): Item? {
        return repository.getItemById(id)
    }
}