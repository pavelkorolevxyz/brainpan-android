package xyz.pavelkorolev.brainpan.core.model

import java.time.LocalDateTime

data class Note(
    val text: String,
    val dateTime: LocalDateTime,
    val id: Long? = null,
)
