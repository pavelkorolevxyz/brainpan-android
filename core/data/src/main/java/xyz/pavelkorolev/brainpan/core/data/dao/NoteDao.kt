package xyz.pavelkorolev.brainpan.core.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import xyz.pavelkorolev.brainpan.core.data.entity.NoteEntity

@Dao
interface NoteDao {

    @Query("SELECT * FROM note")
    suspend fun getAll(): List<NoteEntity>

    @Insert
    suspend fun insert(note: NoteEntity)
}
