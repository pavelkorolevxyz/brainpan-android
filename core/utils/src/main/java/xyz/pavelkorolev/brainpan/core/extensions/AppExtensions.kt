package xyz.pavelkorolev.brainpan.core.extensions

import android.app.Application
import androidx.fragment.app.Fragment

/**
 * Extension function to get the application from a fragment.
 */
val Fragment.app: Application
    get() = requireActivity().application
