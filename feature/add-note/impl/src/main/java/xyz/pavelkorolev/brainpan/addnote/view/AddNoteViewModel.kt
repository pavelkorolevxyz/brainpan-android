package xyz.pavelkorolev.brainpan.addnote.view

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.github.terrakok.cicerone.Router
import javax.inject.Inject

class AddNoteViewModel @Inject constructor(
    private val router: Router,
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
        // TODO save
        Log.d("AddNoteViewModel", "onSaveClick: $text")
        router.exit()
    }
}
