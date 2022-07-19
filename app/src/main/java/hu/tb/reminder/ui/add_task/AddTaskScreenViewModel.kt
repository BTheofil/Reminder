package hu.tb.reminder.ui.add_task

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import hu.tb.reminder.domain.use_case.ValidateTitle
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import javax.inject.Inject

class AddTaskScreenViewModel @Inject constructor(
    private val validateTitle: ValidateTitle
) : ViewModel() {

    var state by mutableStateOf(TaskState())

    private val validationEventChannel = Channel<ValidationEvent>()
    val validationEvents = validationEventChannel.receiveAsFlow()

    fun onEvent(event: ValidationEvent) {
        when(event) {
            is ValidationEvent.TitleChanged -> {
                state = state.copy(title = event.title)
            }
            is ValidationEvent.Submit -> {
                submitTask()
            }
        }
    }

    private fun submitTask(){
        val title = validateTitle.execute(state.title)
    }
}