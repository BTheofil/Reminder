package hu.tb.reminder.ui.task

import hu.tb.reminder.domain.model.Task

sealed class TaskUiEvent {
    data class OnDoneChange(val task: Task, val isDone: Boolean): TaskUiEvent()
    data class OnTaskClick(val task: Task): TaskUiEvent()
    object OnAddTaskClick: TaskUiEvent()
}
