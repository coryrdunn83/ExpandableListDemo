package com.coryrdunn.myapplication.ui.fruit

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coryrdunn.myapplication.domain.models.Fruit
import com.coryrdunn.myapplication.domain.repository.FruitRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FruitScreenViewModel @Inject constructor(
    fruitRepo: FruitRepository
): ViewModel() {

    private val _state = mutableStateOf(FruitUiState())
    val state: State<FruitUiState> = _state

    init {
        viewModelScope.launch {
            fruitRepo.getFruit().collect() {
                _state.value = _state.value.copy(fruit = it)
            }
        }
    }

}

data class FruitUiState(
    val fruit: List<Fruit> = emptyList()
)