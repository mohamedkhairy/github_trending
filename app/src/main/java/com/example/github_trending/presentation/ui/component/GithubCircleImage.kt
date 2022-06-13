package com.example.github_trending.presentation.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import coil.transform.CircleCropTransformation
import com.example.github_trending.R


@Composable
fun GithubCircleImage(imageUrl: String){

    val painter = rememberAsyncImagePainter(
        model = ImageRequest.Builder(LocalContext.current)
            .transformations(CircleCropTransformation())
            .error(R.drawable.github_mark)
            .data(imageUrl)
            .size(300)
            .crossfade(true)
            .crossfade(200)
            .build()
)

    if (painter.state is AsyncImagePainter.State.Loading) {
        CircularProgressIndicator()
    }

    Image(
        painter = painter,
        contentDescription = stringResource(R.string.circle_image_desc),
        modifier = Modifier
            .fillMaxWidth(0.30f)
            .fillMaxHeight()
            .padding(8.dp)
    )

}