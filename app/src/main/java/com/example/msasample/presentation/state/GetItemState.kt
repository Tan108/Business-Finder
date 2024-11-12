package com.example.msasample.presentation.state

import com.example.msasample.data.model.Business

sealed class GetItemState {
    data object Loading:GetItemState()
    data class Success(val listOfBusiness: List<Business>):GetItemState()
    data class Error(val errorMessage:String):GetItemState()
}