package com.example.github_trending.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.example.github_trending.R

@Composable
fun ErrorView(onRetry: () -> Unit){

    val composition by rememberLottieComposition(LottieCompositionSpec.RawRes(R.raw.retry_and_user_busy))

    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center
    ) {

        LottieAnimation(
            composition,
            iterations = LottieConstants.IterateForever,
        )

        Button(onClick = { onRetry() } , modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(backgroundColor = MaterialTheme.colors.surface)
        ) {

            Text(
                modifier = Modifier.padding(8.dp)
                    .align(CenterVertically),
                text = stringResource(R.string.retry),
                color = MaterialTheme.colors.secondary,
                style = MaterialTheme.typography.h5,
                fontSize = 18.sp,
            )

        }
    }
}