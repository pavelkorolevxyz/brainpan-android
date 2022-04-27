package xyz.pavelkorolev.brainpan.feature.notelist.impl.domain.models

import java.time.LocalDateTime

data class Note(
    val text: String,
    val dateTime: LocalDateTime,
)
