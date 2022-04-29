package xyz.pavelkorolev.brainpan.core.data.observer

import xyz.pavelkorolev.brainpan.core.model.Note
import xyz.pavelkorolev.brainpan.observer.PublishEventObserver

/**
 * An observer used to notify about note addition.
 */
class AddNoteEventObserver : PublishEventObserver<Note>()
