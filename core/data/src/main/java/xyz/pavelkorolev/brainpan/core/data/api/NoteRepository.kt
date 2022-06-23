package xyz.pavelkorolev.brainpan.core.data.api

import xyz.pavelkorolev.brainpan.core.model.Note

interface NoteRepository {

    suspend fun getNotes(): List<Note>

    suspend fun createNote(note: Note)

    suspend fun delete(note: Note)
}
