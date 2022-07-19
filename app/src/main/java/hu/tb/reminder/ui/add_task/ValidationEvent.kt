package hu.tb.reminder.ui.add_task

sealed class ValidationEvent {

    data class TitleChanged(val title: String): ValidationEvent()
    object Submit: ValidationEvent()
}