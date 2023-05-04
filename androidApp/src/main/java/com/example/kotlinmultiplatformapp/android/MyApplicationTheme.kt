package com.example.kotlinmultiplatformapp.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.Typography
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val pictonBlue = Color(0xFF318CE7)
val outerSpace = Color(0xFF263238)
val outerSpaceTransparent70 = outerSpace.copy(alpha = 0.7f)
val alabaster = Color(0xFFf9f9f9)

private val LightColorPalette = lightColors(
    primary = pictonBlue,
    secondary = pictonBlue.copy(alpha = 0.5f),
    background = alabaster,
    surface = alabaster,
    onPrimary = outerSpace,
    onSecondary = outerSpace.copy(alpha = 0.5f),
    onBackground = outerSpaceTransparent70,
    onSurface = outerSpaceTransparent70
)

private val fontFamilyOpenSans = FontFamily(
    listOf(
        Font(
            resId = R.font.open_sans_light,
            weight = FontWeight.Light
        )
    )
)

val typography = Typography(
    defaultFontFamily = fontFamilyOpenSans,
    h1 = TextStyle(
        fontFamily = fontFamilyOpenSans,
        fontWeight = FontWeight.Light,
        fontSize = 28.sp
    ),
    h2 = TextStyle(
        fontSize = 16.sp
    ),
    h3 = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    body1 = TextStyle(
        fontSize = 14.sp,
        letterSpacing = 0.sp
    ),
    button = TextStyle(
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = fontFamilyOpenSans,
        fontSize = 12.sp
    ),
)

@Composable
fun MyApplicationTheme(darkTheme: Boolean = isSystemInDarkTheme(), content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = LightColorPalette,
        typography = typography,
        shapes = shapes,
        content = content
    )
}