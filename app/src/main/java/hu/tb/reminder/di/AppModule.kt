package hu.tb.reminder.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import hu.tb.reminder.data.data_source.TaskDatabase
import hu.tb.reminder.data.repository.TaskRepositoryImpl
import hu.tb.reminder.domain.repository.TaskRepository
import hu.tb.reminder.domain.use_case.GetTasks
import hu.tb.reminder.domain.use_case.TaskUseCases
import hu.tb.reminder.domain.use_case.ValidateTitle
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTaskDatabase(app: Application) : TaskDatabase{
        return Room.databaseBuilder(
            app,
            TaskDatabase::class.java,
            TaskDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTaskRepository(db: TaskDatabase) : TaskRepository {
        return TaskRepositoryImpl(db.noteDao)
    }

    @Provides
    @Singleton
    fun provideTaskUseCases(repository: TaskRepository): TaskUseCases {
        return TaskUseCases(
            getTasks = GetTasks(repository)
        )
    }

    @Provides
    @Singleton
    fun provideValidateTitle(): ValidateTitle{
        return ValidateTitle()
    }
}