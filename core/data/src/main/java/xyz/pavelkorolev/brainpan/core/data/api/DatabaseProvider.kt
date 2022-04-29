package xyz.pavelkorolev.brainpan.core.data.api

import android.content.Context
import androidx.room.Room
import xyz.pavelkorolev.brainpan.core.data.AppDatabase

class DatabaseProvider(
    context: Context,
    databaseName: String = "app.db",
) {
    val database: AppDatabase by lazy {
        Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            databaseName,
        ).build()
    }
}
