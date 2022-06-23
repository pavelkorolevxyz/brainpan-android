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
            createdDateTime = LocalDateTime.parse(noteEntity.createdDateTime),
        )

    fun reverseMap(note: Note): NoteEntity =
        NoteEntity(
            id = note.id,
            text = note.text,
            createdDateTime = note.createdDateTime.toString(),
        )
}
