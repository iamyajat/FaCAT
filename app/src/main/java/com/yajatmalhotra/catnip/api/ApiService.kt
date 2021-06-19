package com.yajatmalhotra.catnip.api

import com.yajatmalhotra.catnip.model.CatFact
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("facts/random")
    suspend fun getCatFact(): Response<CatFact>
}
