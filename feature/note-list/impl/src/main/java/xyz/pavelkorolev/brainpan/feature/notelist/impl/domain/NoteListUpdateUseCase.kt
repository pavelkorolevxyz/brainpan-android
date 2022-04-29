package xyz.pavelkorolev.brainpan.feature.notelist.impl.domain

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import xyz.pavelkorolev.brainpan.core.data.observer.AddNoteEventObserver
import javax.inject.Inject

class NoteListUpdateUseCase @Inject constructor(
    private val eventObserver: AddNoteEventObserver,
) {

    operator fun invoke(): Flow<Unit> = eventObserver.eventsFlow.map { }
}
