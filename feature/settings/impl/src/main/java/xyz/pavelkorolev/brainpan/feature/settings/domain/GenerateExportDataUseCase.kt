package xyz.pavelkorolev.brainpan.feature.settings.domain

import xyz.pavelkorolev.brainpan.core.data.api.NoteRepository
import xyz.pavelkorolev.brainpan.core.exporter.Exporter
import javax.inject.Inject

class GenerateExportDataUseCase @Inject constructor(
    private val repository: NoteRepository,
    private val exporter: Exporter,
) {

    suspend operator fun invoke(): String {
        val notes = repository.getNotes()
        return exporter.createJson(notes)
    }
}
