package xyz.pavelkorolev.brainpan.core.data.repository

import xyz.pavelkorolev.brainpan.core.data.api.DatabaseProvider
import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.data.mapper.NoteMapper
import xyz.pavelkorolev.brainpan.core.model.Note
import javax.inject.Inject

class DatabaseNoteRepository @Inject constructor(
    databaseProvider: DatabaseProvider,
    private val mapper: NoteMapper,
) : NoteRepository {

    private val database = databaseProvider.database

    override suspend fun getNotes(): List<Note> =
        database.noteDao()
            .getAll()
            .map(mapper::map)

    override suspend fun createNote(note: Note): Unit =
        database.noteDao()
            .insert(mapper.reverseMap(note))
}
