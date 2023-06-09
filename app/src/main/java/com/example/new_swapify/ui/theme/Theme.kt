package com.example.new_swapify.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.MaterialTheme.shapes
import androidx.compose.material.darkColors
//import androidx.compose.material.dynamicDarkColorScheme
//import androidx.compose.material.dynamicLightColorScheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

private val DarkColorScheme = darkColors(
    primary = Purple200,
//    primaryVariant = Purple700,
    secondary = Green122,
    background = blueBGNight,
    surface = pinkText,
    onSurface = lightmidnight
)

private val LightColorScheme = lightColors(
    primary = Purple500,
//    primaryVariant = Purple700,
    secondary = Teal200,
    background = blueBG,
    surface = blueText,
    onSurface = card
    /* Other default colors to override
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Color.White,
    onSecondary = Color.White,
    onTertiary = Color.White,
    onBackground = Color(0xFF1C1B1F),
    onSurface = Color(0xFF1C1B1F),
    */
)

@Composable
fun My_Theme(content: @Composable() () -> Unit) {

    MaterialTheme(
        colors = DarkColorScheme,
        typography = typography,
        shapes = shapes,
        content = content
    )
}