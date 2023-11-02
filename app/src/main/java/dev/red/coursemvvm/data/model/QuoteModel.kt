package dev.red.coursemvvm.data.model

import com.google.gson.annotations.SerializedName
import dev.red.coursemvvm.core.Keys.AUTHOR
import dev.red.coursemvvm.core.Keys.QUOTE

data class QuoteModel(
    @SerializedName(QUOTE) val quote: String,
    @SerializedName(AUTHOR) val author: String
)