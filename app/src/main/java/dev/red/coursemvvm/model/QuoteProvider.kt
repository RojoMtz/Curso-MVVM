package dev.red.coursemvvm.model

class QuoteProvider {
    companion object {
        fun random(): QuoteModel{
            val position = (0..5).random()
            return quote[position]
        }

        private val quote = listOf(
            QuoteModel(
                quote = "To live is the rarest thing in the world. Most people exist, that is all.",
                author = "Oscar Wilde"
            ),
            QuoteModel(
                quote = "That it will never come again is what makes life so sweet",
                author = "Emily Dickinson"
            ),
            QuoteModel(
                quote = "It is never too late to be what you might have been.",
                author = "George Eliot"
            ),
            QuoteModel(
                quote = "To be yourself in a world that is constantly trying to make you something else is the greatest accomplishment.",
                author = "Ralph Waldo Emerson"
            ),
            QuoteModel(
                quote = "Pain is inevitable. Suffering is optional.",
                author = "Haruki Murakami"
            ),
            QuoteModel(
                quote = "All the world's a stage, and all the men and women merely players.",
                author = "William Shakespeare"
            )
        )
    }
}