package xyz.pavelkorolev.brainpan.feature.addnote.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import xyz.pavelkorolev.brainpan.core.compose.composables.AppScreen

/**
 * TODO not used anywhere
 */
@Composable
fun WorkInProgressScreen() {
    AppScreen {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = "Work in progress",
            )
        }
    }
}
