package xyz.pavelkorolev.brainpan.feature.notelist.impl.domain

import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.model.Note
import javax.inject.Inject

class DeleteNoteUseCase @Inject constructor(
    private val repository: NoteRepository,
) {

    suspend operator fun invoke(note: Note) = repository.delete(note)
}
