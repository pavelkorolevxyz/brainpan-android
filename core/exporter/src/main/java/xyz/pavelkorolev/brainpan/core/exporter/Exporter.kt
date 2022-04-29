package xyz.pavelkorolev.brainpan.core.exporter

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import xyz.pavelkorolev.brainpan.core.exporter.mapper.NoteExportMapper
import xyz.pavelkorolev.brainpan.core.model.Note
import javax.inject.Inject

class Exporter @Inject constructor(
    private val mapper: NoteExportMapper,
) {

    private val json = Json {
        prettyPrint = true
    }

    fun createJson(notes: List<Note>): String {
        val exportNotes = notes.map(mapper::map)
        return json.encodeToString(exportNotes)
    }
}
