package com.example.github_trending.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.github_trending.domain.entity.TrendingDomainModel


@Composable
fun GithubCardItem(data: TrendingDomainModel) {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {


        Row(
            verticalAlignment = Alignment.CenterVertically
        )
        {

            GithubCircleImage(imageUrl = data.avatarUrl)

            Column(
                Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center
            ) {

                Text(
                    text = data.ownerName,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 18.sp
                )

                Spacer(modifier = Modifier.padding(5.dp))

                Text(
                    text = data.description,
                    color = MaterialTheme.colors.onPrimary,
                    fontSize = 14.sp,
                    maxLines = 2
                )

            }

        }

        Spacer(
            modifier = Modifier.padding(2.dp)
                .background(Color.LightGray)
                .fillMaxWidth()
                .requiredHeight(1.dp),
        )

    }
}