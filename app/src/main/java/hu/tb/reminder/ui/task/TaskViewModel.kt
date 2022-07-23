package hu.tb.reminder.ui.task

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.tb.reminder.domain.model.Category
import hu.tb.reminder.domain.model.Task
import hu.tb.reminder.domain.repository.TaskRepository
import hu.tb.reminder.domain.use_case.TaskUseCases
import hu.tb.reminder.util.Routes
import hu.tb.reminder.util.UiEvent
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(
    private val taskRepository: TaskRepository
    ) : ViewModel(){

    private val _tasksState = mutableStateOf(TasksState())
    val tasksState: State<TasksState> = _tasksState

    private val _uiEvent =  Channel<UiEvent>()
    val uiEvent = _uiEvent.receiveAsFlow()

    private var getTasksJob: Job? = null

    init {
        getTasks()
    }

    fun onEvent(event: TaskListEvent){
        when(event){
            is TaskListEvent.OnTaskClick -> {

            }
            is TaskListEvent.OnAddTaskClick -> {
                sendUiEvent(UiEvent.Navigate(Routes.ADD_EDIT_TASK))
            }
            is TaskListEvent.OnDoneChange -> {
                viewModelScope.launch {
                    taskRepository.insertTask(
                        event.task.copy(
                            isDone = event.isDone
                        )
                    )
                }
            }
        }
    }

    private fun sendUiEvent(event: UiEvent) {
        viewModelScope.launch {
            _uiEvent.send(event)
        }
    }

    private fun getTasks(){
        getTasksJob?.cancel()
        getTasksJob = taskRepository.getTasks().onEach { tasks ->
            _tasksState.value = tasksState.value.copy(
                tasks = tasks
            )
        }.launchIn(viewModelScope)
    }
}