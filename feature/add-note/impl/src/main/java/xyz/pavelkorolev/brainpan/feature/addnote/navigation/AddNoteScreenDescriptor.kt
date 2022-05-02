package xyz.pavelkorolev.brainpan.feature.addnote.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import xyz.pavelkorolev.brainpan.feature.addnote.view.AddNoteFragment

/**
 * Add Note Screen navigation description
 */
fun createAddNoteScreen() = FragmentScreen("add_note") {
    AddNoteFragment.newInstance()
}
