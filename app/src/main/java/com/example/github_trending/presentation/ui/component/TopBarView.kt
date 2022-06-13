package com.example.github_trending.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.github_trending.R


@Composable
fun TopBarView() {

    Column(
        Modifier
            .fillMaxWidth()
            .requiredHeight(70.dp)
            .background(MaterialTheme.colors.background),
        verticalArrangement = Arrangement.Center
    ) {


        Text(
            modifier = Modifier.wrapContentWidth()
                .padding(8.dp)
                .align(CenterHorizontally),
            text = stringResource(R.string.trending),
            color = MaterialTheme.colors.onPrimary,
            style = MaterialTheme.typography.h6,
            fontSize = 20.sp,
        )


        Spacer(
            modifier = Modifier
                .padding(2.dp)
                .background(Color.LightGray)
                .fillMaxWidth()
                .requiredHeight(1.dp)

        )

    }
}