package com.example.msasample.domain.usecase

import com.example.msasample.data.repository.GetItemRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GetNearbyItemUseCase @Inject constructor(
    private val repository: GetItemRepository,
) {

    suspend operator fun invoke(item: String) =
        withContext(Dispatchers.IO){ repository.getNearByItem(item = item)}

}