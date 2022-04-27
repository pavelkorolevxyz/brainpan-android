package xyz.pavelkorolev.brainpan.feature.notelist.impl.view.composables

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import xyz.pavelkorolev.brainpan.core.compose.theme.AppTheme
import xyz.pavelkorolev.brainpan.feature.notelist.impl.domain.models.Note
import java.time.LocalDateTime

@Composable
fun NoteCell(
    modifier: Modifier = Modifier,
    note: Note,
) {
    Column(
        modifier = modifier,
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = note.text,
            fontSize = 16.sp,
        )
        Text(
            modifier = Modifier
                .fillMaxWidth()
                .alpha(0.3f),
            text = note.dateTime.toString(),
            fontSize = 12.sp,
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
