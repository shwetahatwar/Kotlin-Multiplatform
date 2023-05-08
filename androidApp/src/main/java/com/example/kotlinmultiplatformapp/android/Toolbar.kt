package com.example.kotlinmultiplatformapp.android

import android.widget.Toolbar
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun Toolbar(
    modifier: Modifier,
    title: String,
    onNavigationIconClick: OnClick = {},
){
Box(modifier = modifier
    .fillMaxWidth()
    .padding(end = 8.dp))
{
    Row(
        modifier = Modifier
            .wrapContentWidth()
            .align(Alignment.CenterStart),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = title,
            overflow = TextOverflow.Ellipsis,
            maxLines = 1,
            modifier = Modifier.wrapContentWidth().weight(1f,false)
        )
    }
}
}