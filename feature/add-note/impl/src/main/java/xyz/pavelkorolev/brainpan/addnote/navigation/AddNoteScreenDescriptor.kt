package xyz.pavelkorolev.brainpan.addnote.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import xyz.pavelkorolev.brainpan.addnote.view.AddNoteFragment

/**
 * Add Note Screen navigation description
 */
fun createAddNoteScreen() = FragmentScreen("add_note") {
    AddNoteFragment.newInstance()
}
