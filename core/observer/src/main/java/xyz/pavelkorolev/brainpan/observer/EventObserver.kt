package xyz.pavelkorolev.brainpan.observer

import kotlinx.coroutines.flow.Flow

interface EventObserver<T> {

    val eventsFlow: Flow<T>

    suspend fun submit(value: T)
}
