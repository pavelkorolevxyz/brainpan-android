package xyz.pavelkorolev.brainpan.core.exporter.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NoteExportEntity(

    @SerialName("text")
    val text: String,

    @SerialName("createdDateTime")
    val createdDateTime: String,
)
