package xyz.pavelkorolev.brainpan.addnote.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.w3c.dom.Text
import xyz.pavelkorolev.brainpan.core.compose.AppScreen

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
