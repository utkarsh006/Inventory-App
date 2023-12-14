package com.example.inventory.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.domain.usecases.ItemUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductListViewModel @Inject constructor(
    private val itemUseCases: ItemUseCases
) : ViewModel() {

    private val _state = mutableStateOf(ProductListState())
    val state: State<ProductListState> get() = _state

    init {
        fetchItems()
    }

    private fun fetchItems() {
        viewModelScope.launch {
            try {
                val items = itemUseCases.getItems.invoke().toList().flatten()
                // Update the state with the new list of items
                _state.value = state.value.copy(items = items)
            } catch (e: Exception) {
                _state.value = e.message?.let { state.value.copy(error = it) }!!
            }
        }
    }

    fun isFavorite(itemId: Int): Boolean {
        return state.value.isFavorite && state.value.items.any { it.id == itemId }
    }

    fun onEvent(event: ProductsEvent) {
        when (event) {
            is ProductsEvent.AddFavorite -> {
                viewModelScope.launch {
                    try {
                        // Call the use case to toggle the item as a favorite
                        itemUseCases.addItem.invoke(event.item)

                        // fetch the updated list of items
                        val updatedItems = itemUseCases.getItems.invoke().toList().flatten()

                        // Update the state with the new list of items
                        _state.value = state.value.copy(items = updatedItems)
                    } catch (e: Exception) {
                        _state.value = e.message?.let { state.value.copy(error = it) }!!
                    }
                }
            }

            is ProductsEvent.DeleteFavorite -> {
                viewModelScope.launch {
                    try {
                        itemUseCases.deleteItem.invoke(event.item)
                        val updatedItems = itemUseCases.getItems.invoke().toList().flatten()
                        _state.value = state.value.copy(items = updatedItems)
                    } catch (e: Exception) {
                        _state.value = e.message?.let { state.value.copy(error = it) }!!
                    }
                }
            }
        }

    }

}
