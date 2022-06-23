package xyz.pavelkorolev.brainpan.core.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "note")
data class NoteEntity(

    @ColumnInfo(name = "text")
    val text: String,

    @ColumnInfo(name = "datetime_created")
    val createdDateTime: String,

    @PrimaryKey(autoGenerate = true)
    val id: Long? = null,
)
