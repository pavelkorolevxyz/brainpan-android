package xyz.pavelkorolev.brainpan.feature.settings.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Divider
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import xyz.pavelkorolev.brainpan.core.compose.composables.AppScreen
import xyz.pavelkorolev.brainpan.core.compose.composables.insets.InsetAwareScaffold
import xyz.pavelkorolev.brainpan.core.compose.composables.insets.InsetAwareTopAppBar
import xyz.pavelkorolev.brainpan.feature.settings.impl.R
import xyz.pavelkorolev.brainpan.core.resources.R as ResourcesR

@Composable
fun SettingsScreen(
    onBackClick: () -> Unit,
    onExportClick: () -> Unit,
) {
    AppScreen {
        InsetAwareScaffold(
            topBar = {
                InsetAwareTopAppBar(
                    title = {
                        Text(text = stringResource(id = R.string.title_settings))
                    },
                    navigationIcon = {
                        IconButton(onClick = onBackClick) {
                            Icon(
                                Icons.Filled.ArrowBack,
                                contentDescription = stringResource(id = ResourcesR.string.action_back),
                            )
                        }
                    },
                )
            },
        ) { contentPadding ->
            LazyColumn(
                modifier = Modifier.padding(contentPadding),
            ) {
                item {
                    SettingsRow(
                        text = stringResource(id = R.string.action_export_data),
                        modifier = Modifier.clickable(onClick = onExportClick),
                    )
                    Divider()
                }
                item {
                    SettingsRow(
                        text = stringResource(id = R.string.action_crash),
                        modifier = Modifier.clickable(
                            onClick = {
                                throw SampleException()
                            },
                        ),
                    )
                    Divider()
                }
            }
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

class SampleException : RuntimeException()
