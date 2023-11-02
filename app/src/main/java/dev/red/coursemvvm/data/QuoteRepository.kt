package dev.red.coursemvvm.data

import dev.red.coursemvvm.data.model.QuoteModel
import dev.red.coursemvvm.data.model.QuoteProvider
import dev.red.coursemvvm.data.network.QuoteService

class QuoteRepository {

    private val api = QuoteService()

    suspend fun getAllQuotes():List<QuoteModel>{
        val response: List<QuoteModel> = api.getQuotes()
        QuoteProvider.quotes = response
        return response
    }
}