package xyz.pavelkorolev.brainpan.feature.notelist.impl.view.composables

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.pavelkorolev.brainpan.core.compose.theme.AppTheme
import xyz.pavelkorolev.brainpan.core.compose.theme.BrainpanColor
import xyz.pavelkorolev.brainpan.core.model.Note
import xyz.pavelkorolev.brainpan.feature.notelist.impl.R
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun NoteCell(
    modifier: Modifier = Modifier,
    note: Note,
) {
    Column(
        modifier = modifier
            .padding(bottom = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = BrainpanColor.Concrete)
            .clickable {
                // TODO open edit screen
            }
            .padding(16.dp),
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = note.text,
            fontSize = 16.sp,
        )
        Spacer(modifier = Modifier.height(4.dp))
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.3f),
            text = note.createdDateTime.format(
                DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT),
            ),
            fontSize = 12.sp,
        )
    }
}

@Composable
fun NoteCellDeleteBackground(
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .padding(bottom = 8.dp)
            .clip(RoundedCornerShape(8.dp))
            .background(color = BrainpanColor.SunsetOrange)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd,
    ) {
        Icon(
            imageVector = Icons.Default.Delete,
            contentDescription = stringResource(id = R.string.action_delete),
            tint = BrainpanColor.White,
        )
    }
}

@Composable
fun NoteCellDismissable(
    note: Note,
    onDismiss: () -> Unit,
) {
    val endToStart = DismissDirection.EndToStart
    val dismissState = rememberDismissState()
    if (dismissState.isDismissed(endToStart)) {
        LaunchedEffect(Unit) {
            onDismiss()
        }
    }
    val modifier = Modifier.padding(horizontal = 16.dp)
    SwipeToDismiss(
        state = dismissState,
        background = {
            NoteCellDeleteBackground(
                modifier = modifier,
            )
        },
        directions = setOf(endToStart),
    ) {
        NoteCell(
            modifier = modifier,
            note = note,
        )
    }
}

@Preview
@Composable
private fun NoteCellPreview() {
    AppTheme {
        NoteCell(note = Note("Hello, world!", LocalDateTime.parse("2020-07-19")))
    }
}
