package xyz.pavelkorolev.brainpan.feature.notelist.impl.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.navigationBarsHeight
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import kotlinx.coroutines.launch
import xyz.pavelkorolev.brainpan.core.compose.AppScreen
import xyz.pavelkorolev.brainpan.core.compose.EmptyView
import xyz.pavelkorolev.brainpan.core.compose.theme.AppTheme
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
        val systemUiController = rememberSystemUiController()
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent,
            )
        }
        NoteListScreenContent(
            state = state,
            onHeaderClick = onHeaderClick,
            onAddClick = onAddClick,
            onSettingsClick = onSettingsClick,
        )
    }
}

@Composable
private fun NoteListScreenContent(
    state: NoteListViewState,
    onHeaderClick: () -> Unit,
    onAddClick: () -> Unit,
    onSettingsClick: () -> Unit,
) {
    val lazyListState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
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
        bottomBar = {
            Spacer(
                Modifier
                    .navigationBarsHeight()
                    .fillMaxWidth(),
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
                    .padding(contentPadding)
                    .fillMaxSize(),
            ) {
                CircularProgressIndicator()
            }
            return@Scaffold
        }
        val notes = state.notes ?: return@Scaffold
        if (notes.isEmpty()) {
            EmptyView(modifier = Modifier.padding(contentPadding))
            return@Scaffold
        }
        LazyColumn(contentPadding = contentPadding, state = lazyListState) {
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
        }
    }
}

@Composable
private fun NoteListTopAppBar(
    onSettingsClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(stringResource(id = R.string.app_name))
        },
        contentPadding = rememberInsetsPaddingValues(
            LocalWindowInsets.current.statusBars,
            applyBottom = false,
        ),
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
    FloatingActionButton(
        onClick = onClick,
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = stringResource(id = R.string.add_note),
        )
    }
}

@Preview(device = Devices.PIXEL)
@Composable
private fun NoteListScreenPreview() {
    AppTheme {
        NoteListScreen(
            state = NoteListViewState(),
            onHeaderClick = {},
            onAddClick = {},
            onSettingsClick = {},
        )
    }
}
