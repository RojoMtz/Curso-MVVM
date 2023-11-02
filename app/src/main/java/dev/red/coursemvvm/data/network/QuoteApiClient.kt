package dev.red.coursemvvm.data.network

import dev.red.coursemvvm.core.Keys.EXTENSION
import dev.red.coursemvvm.data.model.QuoteModel
import retrofit2.Response
import retrofit2.http.GET

interface QuoteApiClient {
    @GET(EXTENSION)
    suspend fun getAllQuotes():Response<List<QuoteModel>>
}