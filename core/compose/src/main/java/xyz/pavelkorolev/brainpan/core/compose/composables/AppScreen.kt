package xyz.pavelkorolev.brainpan.core.compose.composables

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import xyz.pavelkorolev.brainpan.core.compose.theme.AppTheme

@Composable
fun AppScreen(
    backgroundColor: Color = MaterialTheme.colors.background,
    isTransparentBars: Boolean = true,
    content: @Composable () -> Unit,
) {
    AppTheme {
        if (isTransparentBars) {
            val systemUiController = rememberSystemUiController()
            SideEffect {
                systemUiController.setSystemBarsColor(
                    color = Color.Transparent,
                )
            }
        }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = backgroundColor,
            content = content,
        )
    }
}
