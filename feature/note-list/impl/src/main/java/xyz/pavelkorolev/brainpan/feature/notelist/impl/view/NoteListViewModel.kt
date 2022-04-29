package xyz.pavelkorolev.brainpan.feature.notelist.impl.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import xyz.pavelkorolev.brainpan.core.model.Note
import xyz.pavelkorolev.brainpan.feature.addnote.api.AddNoteFeatureApi
import xyz.pavelkorolev.brainpan.feature.notelist.impl.domain.LoadNotesUseCase
import xyz.pavelkorolev.brainpan.feature.notelist.impl.domain.NoteListUpdateUseCase
import xyz.pavelkorolev.brainpan.feature.settings.api.SettingsFeatureApi
import javax.inject.Inject

data class NoteListViewState(
    val notes: List<Note>? = null,
    val isLoading: Boolean = true,
)

class NoteListViewModel @Inject constructor(
    private val addNoteFeatureApi: AddNoteFeatureApi,
    private val settingsFeatureApi: SettingsFeatureApi,
    private val loadNotesUseCase: LoadNotesUseCase,
    private val noteListUpdateUseCase: NoteListUpdateUseCase,
) : ViewModel() {

    var viewState by mutableStateOf(NoteListViewState())
        private set

    init {
        loadNotes()
        subscribeForUpdates()
    }

    private fun loadNotes() {
        viewModelScope.launch {
            val notes = loadNotesUseCase().reversed()
            viewState = viewState.copy(notes = notes, isLoading = false)
        }
    }

    private fun subscribeForUpdates() {
        viewModelScope.launch {
            noteListUpdateUseCase()
                .onEach {
                    loadNotes()
                }
                .collect()
        }
    }

    fun onHeaderClick() {
        viewState = NoteListViewState()
        loadNotes()
    }

    fun onAddClick() {
        addNoteFeatureApi.navigateAddNote()
    }

    fun onSettingsClick() {
        settingsFeatureApi.navigateSettings()
    }
}
