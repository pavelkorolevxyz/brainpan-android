package xyz.pavelkorolev.brainpan.observer

import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow

/**
 * Hot observer implementation
 */
open class PublishEventObserver<T> : EventObserver<T> {

    private val updatesBroadcast: BroadcastChannel<T> = BroadcastChannel(1)

    /**
     * Returns a flow of events.
     */
    override val eventsFlow: Flow<T>
        get() = updatesBroadcast.asFlow()

    /**
     * Submits an event to the observer.
     */
    override suspend fun submit(value: T) {
        updatesBroadcast.send(value)
    }
}
