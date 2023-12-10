package com.example.inventory.presentation

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.Resource
import com.example.inventory.data.dataClasses.Item
import com.example.inventory.domain.repository.ItemRepository
import com.example.inventory.domain.usecases.GetItems
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject


@HiltViewModel
class ProductListViewModel @Inject constructor(
) : ViewModel() {

    private val _state = mutableStateOf(ProductListState())
    val state: State<ProductListState> get() = _state // exposing this state to the composables



}
