package xyz.pavelkorolev.brainpan.feature.addnote.domain

import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.data.observer.AddNoteEventObserver
import xyz.pavelkorolev.brainpan.core.model.Note
import java.time.LocalDateTime
import javax.inject.Inject

class SaveNoteUseCase @Inject constructor(
    private val repository: NoteRepository,
    private val addNoteEventObserver: AddNoteEventObserver,
) {

    suspend operator fun invoke(text: String) {
        val note = Note(
            text = text,
            createdDateTime = LocalDateTime.now(),
        )
        repository.createNote(note)
        addNoteEventObserver.submit(note)
    }
}
