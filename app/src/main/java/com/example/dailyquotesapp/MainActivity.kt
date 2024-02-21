package com.example.dailyquotesapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.dailyquotesapp.data.DataSource
import com.example.dailyquotesapp.model.Quote
import com.example.dailyquotesapp.ui.theme.DailyQuotesAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DailyQuotesAppTheme {
                QuotesApp()
            }
        }
    }
}

@Composable
fun QuotesApp()
{
    QuotesList(
        quotesList = DataSource().loadQuotes()
    )
}

@Composable
fun QuotesList(quotesList:List<Quote>, modifier:Modifier = Modifier)
{
    LazyColumn {
        items(quotesList){
            quote: Quote -> QuoteCard(quote = quote,
            modifier = Modifier.padding(8.dp))

        }
    }
}

@Composable
fun QuoteCard(quote: Quote, modifier:Modifier = Modifier)
{
    Card(modifier = modifier)
    {
        Column {
            Row {
                Text(
                    text = stringResource(id = quote.authorResourceId),
                    modifier = modifier.padding(10.dp),
                    style = MaterialTheme.typography.headlineLarge

                )
                Image(
                    painter = painterResource(id = quote.imageResourceId),
                    contentDescription = stringResource(id = quote.stringResourceId),
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(200.dp)
                        .clip(CircleShape)
                )

            }

            Text(
                text = stringResource(id = quote.stringResourceId),
                modifier = modifier.padding(10.dp),
                style = MaterialTheme.typography.headlineSmall

            )
        }
    }

}

@Preview
@Composable
fun QuoteCardPreview(){
    QuotesApp()
}