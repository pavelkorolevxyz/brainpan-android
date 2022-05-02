package xyz.pavelkorolev.brainpan.core.compose.composables

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import xyz.pavelkorolev.brainpan.core.compose.R

@Composable
fun WorkInProgressScreen() {
    AppScreen {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize(),
        ) {
            Text(
                text = stringResource(id = R.string.title_work_in_progress),
            )
        }
    }
}
