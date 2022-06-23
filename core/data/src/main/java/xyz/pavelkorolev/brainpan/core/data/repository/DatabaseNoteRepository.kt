package xyz.pavelkorolev.brainpan.core.data.repository

import xyz.pavelkorolev.brainpan.core.data.api.DatabaseProvider
import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.data.dao.NoteDao
import xyz.pavelkorolev.brainpan.core.data.mapper.NoteMapper
import xyz.pavelkorolev.brainpan.core.model.Note
import javax.inject.Inject

class DatabaseNoteRepository @Inject constructor(
    databaseProvider: DatabaseProvider,
    private val mapper: NoteMapper,
) : NoteRepository {

    private val database = databaseProvider.database
    private val dao: NoteDao get() = database.noteDao()

    override suspend fun getNotes(): List<Note> =
        dao.getAll().map(mapper::map)

    override suspend fun createNote(note: Note): Unit =
        dao.insert(mapper.reverseMap(note))

    override suspend fun delete(note: Note) {
        dao.delete(mapper.reverseMap(note))
    }
}
