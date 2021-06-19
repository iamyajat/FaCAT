package com.yajatmalhotra.catnip.repository

import com.yajatmalhotra.catnip.api.ApiService
import javax.inject.Inject

class CatFactRepository
@Inject
constructor(private val apiService: ApiService) {
    suspend fun getCatFact() = apiService.getCatFact()
}
