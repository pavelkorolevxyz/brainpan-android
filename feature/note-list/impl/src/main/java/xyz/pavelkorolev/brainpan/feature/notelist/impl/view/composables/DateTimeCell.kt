package xyz.pavelkorolev.brainpan.feature.notelist.impl.view.composables

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import xyz.pavelkorolev.brainpan.core.compose.theme.AppTheme
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.format.FormatStyle

@Composable
fun DateTimeCell(dateTime: LocalDateTime) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .padding(top = 16.dp)
            .alpha(0.3f),
        text = dateTime.format(
            DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL),
        ).uppercase(),
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
    )
}

@Preview
@Composable
private fun DateTimeCellPreview() {
    AppTheme {
        DateTimeCell(LocalDateTime.now())
    }
}
