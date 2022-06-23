package xyz.pavelkorolev.brainpan.core.model

import java.time.LocalDateTime

data class Note(
    val text: String,
    val createdDateTime: LocalDateTime,
    val id: Long? = null,
)
