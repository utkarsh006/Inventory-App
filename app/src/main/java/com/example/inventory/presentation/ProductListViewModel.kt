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
                _state.value = _state.value.copy(items = items)
            } catch (e: Exception) {
                _state.value = e.message?.let { _state.value.copy(error = it) }!!
            }
        }
    }

    fun onEvent(event: ProductsEvent) {
        when (event) {
            is ProductsEvent.ToggleFavorite -> {
                viewModelScope.launch {
                    try {
                        // Call the use case to toggle the item as a favorite
                        itemUseCases.addItem.invoke(event.item)

                        // Optionally, you may want to fetch the updated list of items
                        val updatedItems = itemUseCases.getItems.invoke().toList().flatten()

                        // Update the state with the new list of items
                        _state.value = _state.value.copy(items = updatedItems)
                    } catch (e: Exception) {
                        _state.value = e.message?.let { _state.value.copy(error = it) }!!
                    }
                }
            }
        }

    }
}
