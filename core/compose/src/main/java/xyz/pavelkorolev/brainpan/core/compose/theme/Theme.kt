package xyz.pavelkorolev.brainpan.core.compose.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable

private val LightColors = lightColors(
    background = BrainpanColor.White,
    primary = BrainpanColor.FountainBlue,
    secondary = BrainpanColor.MySin,
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = LightColors,
        typography = Typography,
        shapes = Shapes,
        content = content,
    )
}
