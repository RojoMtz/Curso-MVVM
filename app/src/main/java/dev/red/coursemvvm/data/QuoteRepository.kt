package dev.red.coursemvvm.data

import dev.red.coursemvvm.data.model.QuoteModel
import dev.red.coursemvvm.data.model.QuoteProvider
import dev.red.coursemvvm.data.network.QuoteService
import javax.inject.Inject

class QuoteRepository @Inject constructor(
    private val api: QuoteService,
    private val quoteProvider: QuoteProvider
) {
    suspend fun getAllQuotes():List<QuoteModel>{
        val response = api.getQuotes()
        quoteProvider.quotes = response
        return response
    }
}