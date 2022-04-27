package xyz.pavelkorolev.brainpan.addnote.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import xyz.pavelkorolev.brainpan.addnote.view.AddFragment

/**
 * Add Note Screen navigation description
 */
fun createAddNoteScreen() = FragmentScreen("add_note") {
    AddFragment.newInstance()
}
