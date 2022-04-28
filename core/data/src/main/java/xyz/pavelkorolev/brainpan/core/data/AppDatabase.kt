package xyz.pavelkorolev.brainpan.core.data

import androidx.room.Database
import androidx.room.RoomDatabase
import xyz.pavelkorolev.brainpan.core.data.dao.NoteDao
import xyz.pavelkorolev.brainpan.core.data.entity.NoteEntity

@Database(
    entities = [
        NoteEntity::class,
    ],
    version = 1,
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun noteDao(): NoteDao
}
