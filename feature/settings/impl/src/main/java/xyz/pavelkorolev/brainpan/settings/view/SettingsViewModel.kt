package xyz.pavelkorolev.brainpan.settings.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.launch
import xyz.pavelkorolev.brainpan.settings.domain.GenerateExportDataUseCase
import javax.inject.Inject

class SettingsViewModel @Inject constructor(
    private val router: Router,
    private val generateExportDataUseCase: GenerateExportDataUseCase,
) : ViewModel() {

    private val _jsonShareEvents = MutableSharedFlow<String>()
    val jsonShareEvents: Flow<String> = _jsonShareEvents

    fun onBackClick() {
        router.exit()
    }

    fun onExportClick() {
        viewModelScope.launch {
            val json = generateExportDataUseCase()
            _jsonShareEvents.emit(json)
        }
    }
}
