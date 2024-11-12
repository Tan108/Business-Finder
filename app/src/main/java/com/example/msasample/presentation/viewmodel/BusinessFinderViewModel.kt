package com.example.msasample.presentation.viewmodel

import androidx.annotation.VisibleForTesting
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.msasample.domain.usecase.GetNearbyItemUseCase
import com.example.msasample.presentation.state.GetItemState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class BusinessFinderViewModel @Inject constructor(
    private val getNearbyItemUseCase: GetNearbyItemUseCase,
) : ViewModel() {

    private val _getItemState = MutableStateFlow<GetItemState>(GetItemState.Loading)
    val getItemState: StateFlow<GetItemState> get() = _getItemState

    private val getItemException = CoroutineExceptionHandler { _, throwable ->
        _getItemState.value = GetItemState.Error(throwable.localizedMessage.orEmpty())
    }

    init {
        getItem()
    }

    @VisibleForTesting
     fun getItem() {
        viewModelScope.launch(getItemException) {
            val pizzaBusiness = getNearbyItemUseCase("pizza").businesses
            val juiceBusiness = getNearbyItemUseCase("juice").businesses

            _getItemState.value = GetItemState.Success(pizzaBusiness + juiceBusiness)
        }
    }
}