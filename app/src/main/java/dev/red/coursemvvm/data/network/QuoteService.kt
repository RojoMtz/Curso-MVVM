package dev.red.coursemvvm.data.network

import dev.red.coursemvvm.core.RetrofitHelper
import dev.red.coursemvvm.data.model.QuoteModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response
import javax.inject.Inject

class QuoteService @Inject constructor(
    private val api: QuoteApiClient
) {
    suspend fun getQuotes():List<QuoteModel>{
        return withContext(Dispatchers.IO){
            val response = api.getAllQuotes()
            response.body() ?: emptyList()
        }
    }
}
