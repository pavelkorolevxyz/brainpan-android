package xyz.pavelkorolev.brainpan.feature.notelist.impl.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch
import xyz.pavelkorolev.brainpan.core.compose.composables.AppScreen
import xyz.pavelkorolev.brainpan.core.compose.composables.EmptyView
import xyz.pavelkorolev.brainpan.core.compose.composables.insets.InsetAwareFloatingActionButton
import xyz.pavelkorolev.brainpan.core.compose.composables.insets.InsetAwareScaffold
import xyz.pavelkorolev.brainpan.core.compose.composables.insets.InsetAwareTopAppBar
import xyz.pavelkorolev.brainpan.feature.notelist.impl.R
import xyz.pavelkorolev.brainpan.feature.notelist.impl.view.composables.DateTimeCell
import xyz.pavelkorolev.brainpan.feature.notelist.impl.view.composables.NoteCell
import java.time.LocalDate

@Composable
fun NoteListScreen(
    state: NoteListViewState,
    onHeaderClick: () -> Unit,
    onAddClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    AppScreen {
        val lazyListState = rememberLazyListState()
        val coroutineScope = rememberCoroutineScope()
        InsetAwareScaffold(
            topBar = {
                NoteListTopAppBar(
                    onBackClick = {
                        onHeaderClick()
                        coroutineScope.launch {
                            lazyListState.animateScrollToItem(0)
                        }
                    },
                    onSettingsClick = onSettingsClick,
                )
            },
            floatingActionButton = {
                NoteListFloatingActionButton(onClick = onAddClick)
            },
        ) { contentPadding ->
            if (state.isLoading) {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .fillMaxSize(),
                ) {
                    CircularProgressIndicator()
                }
                return@InsetAwareScaffold
            }
            val notes = state.notes ?: return@InsetAwareScaffold
            if (notes.isEmpty()) {
                EmptyView()
                return@InsetAwareScaffold
            }
            LazyColumn(
                contentPadding = contentPadding,
                state = lazyListState,
            ) {
                var prevDate: LocalDate? = null
                for (note in notes) {
                    val noteDate = note.dateTime.toLocalDate()
                    if (prevDate != noteDate) {
                        prevDate = noteDate
                        item {
                            DateTimeCell(dateTime = note.dateTime)
                        }
                    }
                    item {
                        NoteCell(
                            modifier = Modifier.padding(horizontal = 16.dp),
                            note = note,
                        )
                    }
                }
                item {
                    Spacer(Modifier.height(80.dp))
                }
            }
        }
    }
}

@Composable
private fun NoteListTopAppBar(
    onSettingsClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    InsetAwareTopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name))
        },
        actions = {
            IconButton(onClick = onSettingsClick) {
                Icon(Icons.Filled.Settings, contentDescription = null)
            }
        },
        modifier = Modifier.clickable(onClick = onBackClick),
    )
}

@Composable
private fun NoteListFloatingActionButton(onClick: () -> Unit) {
    InsetAwareFloatingActionButton(onClick = onClick) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.add_note),
        )
    }
}
