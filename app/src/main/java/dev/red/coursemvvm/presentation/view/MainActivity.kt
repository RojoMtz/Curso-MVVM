package dev.red.coursemvvm.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import dagger.hilt.android.AndroidEntryPoint
import dev.red.coursemvvm.databinding.ActivityMainBinding
import dev.red.coursemvvm.presentation.viewmodel.QuoteViewModel

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val quoteViewModel: QuoteViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
        quoteViewModel.onCreate()
        execRandom()
    }

    fun init() {
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun execRandom() {
        quoteViewModel.quoteModel.observe(this, Observer { currentQuote ->
            binding.tvQuote.text = currentQuote.quote
            binding.tvAuthor.text = currentQuote.author
            Log.d("TAG INFO: ", currentQuote.toString())
        })

        quoteViewModel.isLoading.observe(this, Observer {
            binding.progess.isVisible = it
        })
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }
    }
}