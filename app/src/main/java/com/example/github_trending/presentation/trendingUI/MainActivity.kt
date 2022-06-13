package com.example.github_trending.presentation.trendingUI

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.fragment.app.viewModels
import com.example.github_trending.presentation.ui.component.GithubCardItem
import com.example.github_trending.presentation.ui.shimmer.AnimatedShimmer
import com.example.github_trending.presentation.ui.theme.GithubTrendingTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val trendingViewModel: TrendingViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GithubTrendingTheme {
                // A surface container using the 'background' color from the theme
                val trendingList = trendingViewModel.trendingList.value
                val isLoading = trendingViewModel.loading.value

                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                Box(
                    modifier = Modifier.fillMaxSize()

                ) {

                    if (isLoading)
                        Column {
                            repeat(8) {
                                AnimatedShimmer()
                            }
                        }

                    LazyColumn {
                        itemsIndexed(items = trendingList) { index, item ->
                            GithubCardItem(data = item)
                        }
                    }


                }}

//                Surface(
//                    modifier = Modifier.fillMaxSize(),
//                    color = MaterialTheme.colors.background
//                ) {
//
//                    Column {
//                        repeat(8) {
//                            AnimatedShimmer()
//                        }
//                    }
//
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubTrendingTheme {
        Greeting("Android")
    }
}