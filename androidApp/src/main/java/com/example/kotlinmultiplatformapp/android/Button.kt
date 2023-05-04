package com.example.kotlinmultiplatformapp.android

import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp


//for onclick
typealias SimpleEvent = () -> Unit
typealias OnClick = SimpleEvent

@Composable
fun FilledButton(modifier: androidx.compose.ui.Modifier = androidx.compose.ui.Modifier,
           onClick: OnClick,
                 text: String,
                 isEnabled: Boolean = true)
{
    Button(
        modifier = modifier
            .heightIn(min = 50.dp)
            .widthIn(min = 120.dp),
        onClick = onClick,
        enabled = isEnabled,
        shape = MaterialTheme.shapes.small,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = MaterialTheme.colors.primary,
            disabledBackgroundColor = MaterialTheme.colors.primary.copy(alpha = 0.5f),
            contentColor = Color.White,
            disabledContentColor = Color.White
        )
    ){
        Text(
            text = text,
            style = MaterialTheme.typography.h2
        )
    }

}