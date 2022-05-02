package xyz.pavelkorolev.brainpan.feature.addnote.domain

import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.data.observer.AddNoteEventObserver
import xyz.pavelkorolev.brainpan.core.model.Note
import javax.inject.Inject

class SaveNoteUseCase @Inject constructor(
    private val repository: NoteRepository,
    private val addNoteEventObserver: AddNoteEventObserver,
) {

    suspend operator fun invoke(note: Note) {
        repository.createNote(note)
        addNoteEventObserver.submit(note)
    }
}
