package xyz.pavelkorolev.brainpan.addnote.view

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.LocalWindowInsets
import com.google.accompanist.insets.rememberInsetsPaddingValues
import com.google.accompanist.insets.ui.Scaffold
import com.google.accompanist.insets.ui.TopAppBar
import xyz.pavelkorolev.brainpan.addnote.impl.R
import xyz.pavelkorolev.brainpan.core.compose.composables.AppScreen

@Composable
fun AddNoteScreen(
    noteText: String,
    onBackClick: () -> Unit,
    onTextChange: (String) -> Unit,
    onSaveClick: () -> Unit,
) {
    AppScreen {
        AppScreenContent(
            noteText = noteText,
            onBackClick = onBackClick,
            onTextChange = onTextChange,
            onSaveClick = onSaveClick,
        )
    }
}

@Composable
fun AppScreenContent(
    noteText: String,
    onBackClick: () -> Unit,
    onSaveClick: () -> Unit,
    onTextChange: (String) -> Unit,
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.title_add_note))
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
        Column(
            modifier = Modifier
                .padding(contentPadding)
                .fillMaxSize()
                .padding(16.dp),
        ) {
            BrainpanTextField(
                modifier = Modifier.fillMaxWidth(),
                value = noteText,
                onValueChange = onTextChange,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                modifier = Modifier.fillMaxWidth(),
                onClick = onSaveClick,
            ) {
                Text(text = stringResource(id = R.string.action_save).uppercase())
            }
        }
    }
}

@Composable
fun BrainpanTextField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = onValueChange,
        keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences,
        ),
        label = { Text(text = stringResource(id = R.string.label_note_text)) },
    )
}
