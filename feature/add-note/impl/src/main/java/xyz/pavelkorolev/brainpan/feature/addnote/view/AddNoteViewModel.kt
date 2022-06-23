package xyz.pavelkorolev.brainpan.feature.addnote.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.launch
import xyz.pavelkorolev.brainpan.feature.addnote.domain.SaveNoteUseCase
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(
    private val router: Router,
    private val saveNoteUseCase: SaveNoteUseCase,
) : ViewModel() {

    var text: String by mutableStateOf("")
        private set

    fun onTextChange(text: String) {
        this.text = text
    }

    fun onBackClick() {
        router.exit()
    }

    fun onSaveClick() {
        viewModelScope.launch {
            saveNoteUseCase(text = text)
            router.exit()
        }
    }
}
