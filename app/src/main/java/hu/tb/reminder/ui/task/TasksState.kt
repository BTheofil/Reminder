package hu.tb.reminder.ui.task

import hu.tb.reminder.domain.model.Task

data class TasksState(
    val tasks: List<Task> = emptyList()
)
