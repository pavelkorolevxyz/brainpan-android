package xyz.pavelkorolev.brainpan.feature.notelist.impl.data

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import xyz.pavelkorolev.brainpan.feature.notelist.impl.domain.models.Note
import java.time.LocalDate
import kotlin.random.Random

object MockNoteFactory {

    suspend fun create(): List<Note> = withContext(Dispatchers.IO) {
        val now = LocalDate.of(2022, 2, 24)
        var date = LocalDate.now()
        val list = mutableListOf<Note>()
        while (date > now) {
            val value = buildList {
                repeat(Random.nextInt(3) + 1) {
                    add(
                        Note(
                            LoremIpsum(Random.nextInt(20) + 3).values.joinToString(" "),
                            date.atStartOfDay(),
                        ),
                    )
                }
            }
            list.addAll(value)
            date = date.minusDays(1)
        }
        delay(1_000)
        list
    }
}
