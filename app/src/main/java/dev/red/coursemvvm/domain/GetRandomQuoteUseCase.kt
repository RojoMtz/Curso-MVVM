package dev.red.coursemvvm.domain

import dev.red.coursemvvm.data.model.QuoteModel
import dev.red.coursemvvm.data.model.QuoteProvider
import javax.inject.Inject

class GetRandomQuoteUseCase @Inject constructor(
    private val quoteProvider: QuoteProvider
){
    operator fun invoke():QuoteModel?{
        val quotes = quoteProvider.quotes
        if(!quotes.isNullOrEmpty()){
            val randomNumber = (quotes.indices).random()
            return quotes[randomNumber]
        }
        return null
    }
}