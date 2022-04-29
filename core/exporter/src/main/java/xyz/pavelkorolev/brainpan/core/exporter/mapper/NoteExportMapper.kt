package xyz.pavelkorolev.brainpan.core.exporter.mapper

import xyz.pavelkorolev.brainpan.core.exporter.model.NoteExportEntity
import xyz.pavelkorolev.brainpan.core.model.Note
import javax.inject.Inject

class NoteExportMapper @Inject constructor() {

    fun map(note: Note): NoteExportEntity {
        return NoteExportEntity(
            text = note.text,
            dateTime = note.dateTime.toString(),
        )
    }
}
