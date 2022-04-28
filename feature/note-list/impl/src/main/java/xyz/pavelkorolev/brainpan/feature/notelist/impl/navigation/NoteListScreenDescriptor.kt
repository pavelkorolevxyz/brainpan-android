package xyz.pavelkorolev.brainpan.feature.notelist.impl.navigation

import com.github.terrakok.cicerone.androidx.FragmentScreen
import xyz.pavelkorolev.brainpan.feature.notelist.impl.view.NoteListFragment

fun createNoteListScreen() = FragmentScreen {
    NoteListFragment.newInstance()
}
