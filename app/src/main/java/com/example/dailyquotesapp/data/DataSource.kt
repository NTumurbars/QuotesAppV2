package com.example.dailyquotesapp.data

import com.example.dailyquotesapp.model.Quote
import com.example.quotesappv2.R


class DataSource {

    fun loadQuotes(): List<Quote>{
        return listOf<Quote>(
            Quote(R.string.quote1, R.drawable.image1, R.string.author1),
            Quote(R.string.quote2, R.drawable.image2, R.string.author2),
            Quote(R.string.quote3, R.drawable.image3, R.string.author3),
            Quote(R.string.quote4, R.drawable.image4, R.string.author4),
            Quote(R.string.quote5, R.drawable.image5, R.string.author5),
            Quote(R.string.quote6, R.drawable.image6, R.string.author6),
            Quote(R.string.quote7, R.drawable.image7, R.string.author7),
            Quote(R.string.quote8, R.drawable.image8, R.string.author8),
            Quote(R.string.quote9, R.drawable.image9, R.string.author9),
            Quote(R.string.quote10, R.drawable.image10, R.string.author10)
        )
    }

}