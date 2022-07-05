package hu.tb.reminder.domain.use_case

import hu.tb.reminder.domain.model.Task
import hu.tb.reminder.domain.repository.TaskRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetTasks(
    private val repository: TaskRepository
) {

    operator fun invoke(): Flow<List<Task>> = repository.getTasks().map { tasks ->
            tasks.sortedBy { it.title }
        }
}