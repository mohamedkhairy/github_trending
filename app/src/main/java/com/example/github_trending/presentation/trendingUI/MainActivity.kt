package com.example.github_trending.presentation.trendingUI

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.github_trending.presentation.ui.component.ErrorView
import com.example.github_trending.presentation.ui.component.GithubCardItem
import com.example.github_trending.presentation.ui.component.TopBarView
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
                val isError = trendingViewModel.isError.value

                Column(modifier = Modifier.fillMaxSize()) {
                    TopBarView()

                    if (isError) {
                        ErrorView {
                            trendingViewModel.getTrendingGithubList()
                        }
                    } else {
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


                            }
                        }

                    }
                }
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    GithubTrendingTheme {
    }
}