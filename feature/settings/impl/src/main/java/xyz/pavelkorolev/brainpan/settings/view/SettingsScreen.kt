package xyz.pavelkorolev.brainpan.settings.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import xyz.pavelkorolev.brainpan.core.compose.composables.AppScreen
import xyz.pavelkorolev.brainpan.feature.settings.impl.R

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onExportClick: () -> Unit,
) {
    AppScreen {
        AppScreenContent(
            onBackClick = onBackClick,
            onExportClick = onExportClick,
        )
    }
}

@Composable
fun AppScreenContent(
    onBackClick: () -> Unit,
    onExportClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.title_settings))
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = null) // TODO
                    }
                },
                contentPadding = rememberInsetsPaddingValues(
                    LocalWindowInsets.current.statusBars,
                    applyBottom = false,
                ),
            )
        },
    ) { contentPadding ->
        Column(modifier = Modifier.padding(contentPadding)) {
            SettingsRow(
                text = stringResource(id = R.string.action_export_data),
                modifier = Modifier.clickable(onClick = onExportClick),
            )
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(color = Color.Black.copy(alpha = 0.1f)),
            )
        }
    }
}

@Composable
fun SettingsRow(
    text: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(16.dp),
    ) {
        Text(text = text)
    }
}
