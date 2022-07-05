package hu.tb.reminder.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import hu.tb.reminder.domain.model.Task

@Database(
    entities = [Task::class],
    version = 1
)
abstract class TaskDatabase : RoomDatabase(){

    abstract val noteDao: TaskDao

    companion object {
        const val DATABASE_NAME = "tasks_db"
    }
}