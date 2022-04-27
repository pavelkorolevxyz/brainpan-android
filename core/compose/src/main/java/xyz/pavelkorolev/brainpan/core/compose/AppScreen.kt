package xyz.pavelkorolev.brainpan.core.compose

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.insets.ProvideWindowInsets
import xyz.pavelkorolev.brainpan.core.compose.theme.AppTheme

@Composable
fun AppScreen(
    backgroundColor: Color = MaterialTheme.colors.background,
    content: @Composable () -> Unit,
) {
    AppTheme {
        ProvideWindowInsets {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = backgroundColor,
                content = content,
            )
        }
    }
}
