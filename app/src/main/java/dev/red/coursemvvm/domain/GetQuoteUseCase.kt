package dev.red.coursemvvm.domain

import dev.red.coursemvvm.data.QuoteRepository
import dev.red.coursemvvm.data.model.QuoteModel
import javax.inject.Inject

class GetQuoteUseCase @Inject constructor(
    private val repository: QuoteRepository
) {
    suspend operator fun invoke() = repository.getAllQuotes()
}