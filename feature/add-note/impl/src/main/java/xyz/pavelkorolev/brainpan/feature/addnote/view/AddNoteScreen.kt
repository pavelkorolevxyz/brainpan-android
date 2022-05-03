package xyz.pavelkorolev.brainpan.feature.addnote.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import xyz.pavelkorolev.brainpan.core.compose.composables.AppScreen
import xyz.pavelkorolev.brainpan.core.compose.composables.BrainpanTextField
import xyz.pavelkorolev.brainpan.feature.addnote.impl.R
import xyz.pavelkorolev.brainpan.core.resources.R as ResourcesR

@Composable
fun AddNoteScreen(
    noteText: String,
    onBackClick: () -> Unit,
    onTextChange: (String) -> Unit,
    onSaveClick: () -> Unit,
) {
    AppScreen {
        Scaffold(
            topBar = {
                AddNoteTopAppBar(onBackClick)
            },
        ) { contentPadding ->
            Column(
                modifier = Modifier
                    .padding(contentPadding)
                    .padding(
                        WindowInsets.systemBars
                            .only(WindowInsetsSides.Horizontal)
                            .asPaddingValues(),
                    )
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                val focusRequester = remember { FocusRequester() }
                BrainpanTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .focusRequester(focusRequester),
                    value = noteText,
                    onValueChange = onTextChange,
                    label = stringResource(id = R.string.label_note_text),
                )
                Spacer(modifier = Modifier.height(16.dp))
                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onSaveClick,
                ) {
                    Text(text = stringResource(id = R.string.action_save).uppercase())
                }
                LaunchedEffect(Unit) {
                    focusRequester.requestFocus()
                }
            }
        }
    }
}

@Composable
private fun AddNoteTopAppBar(onBackClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.title_add_note))
        },
        contentPadding = WindowInsets.systemBars
            .only(WindowInsetsSides.Horizontal + WindowInsetsSides.Top)
            .asPaddingValues(),
        navigationIcon = {
            IconButton(onClick = onBackClick) {
                Icon(
                    Icons.Filled.ArrowBack,
                    contentDescription = stringResource(id = ResourcesR.string.action_back),
                )
            }
        },
    )
}
