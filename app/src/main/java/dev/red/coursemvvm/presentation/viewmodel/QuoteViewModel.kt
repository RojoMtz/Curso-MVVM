package dev.red.coursemvvm.presentation.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.red.coursemvvm.data.model.QuoteModel
import dev.red.coursemvvm.data.model.QuoteProvider
import dev.red.coursemvvm.domain.GetQuoteUseCase
import dev.red.coursemvvm.domain.GetRandomQuoteUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class QuoteViewModel @Inject constructor(
    private val getQuotesUseCase:GetQuoteUseCase,
    private val getRandomQuoteUseCase:GetRandomQuoteUseCase
) : ViewModel() {

    val quoteModel = MutableLiveData<QuoteModel>()
    val isLoading = MutableLiveData<Boolean>()

    fun onCreate() {
        viewModelScope.launch {
            isLoading.postValue(true)
            val result = getQuotesUseCase()

            if(!result.isNullOrEmpty()){
                quoteModel.postValue(result[0])
                isLoading.postValue(false)
            }
        }
    }

    fun randomQuote() {
        isLoading.postValue(true)
        val quote = getRandomQuoteUseCase()
        if(quote!=null){
            quoteModel.postValue(quote)
        }
        isLoading.postValue(false)
    }
}