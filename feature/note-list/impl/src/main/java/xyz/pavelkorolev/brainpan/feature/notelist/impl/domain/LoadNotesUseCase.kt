package xyz.pavelkorolev.brainpan.feature.notelist.impl.domain

import xyz.pavelkorolev.brainpan.feature.notelist.impl.data.MockNoteFactory
import xyz.pavelkorolev.brainpan.feature.notelist.impl.domain.models.Note
import javax.inject.Inject

class LoadNotesUseCase @Inject constructor() {

    suspend operator fun invoke(): List<Note> {
        return MockNoteFactory.create()
    }
}
