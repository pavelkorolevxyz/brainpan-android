package xyz.pavelkorolev.brainpan.core.data.mapper

import xyz.pavelkorolev.brainpan.core.data.entity.NoteEntity
import xyz.pavelkorolev.brainpan.core.model.Note
import java.time.LocalDateTime
import javax.inject.Inject

class NoteMapper @Inject constructor() {

    fun map(noteEntity: NoteEntity): Note =
        Note(
            id = noteEntity.id,
            text = noteEntity.text,
            dateTime = LocalDateTime.parse(noteEntity.createdDate),
        )

    fun reverseMap(note: Note): NoteEntity =
        NoteEntity(
            id = note.id,
            text = note.text,
            createdDate = note.dateTime.toString(),
        )
}
