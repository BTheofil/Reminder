package hu.tb.reminder.ui.task

import hu.tb.reminder.domain.model.Task

sealed class TaskListEvent {
    data class OnDoneChange(val task: Task, val isDone: Boolean): TaskListEvent()
    data class OnTaskClick(val task: Task): TaskListEvent()
    object OnAddTaskClick: TaskListEvent()
}
