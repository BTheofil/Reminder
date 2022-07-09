package hu.tb.reminder.ui.task

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import hu.tb.reminder.domain.use_case.TaskUseCases
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TaskViewModel @Inject constructor(private val taskUseCases: TaskUseCases) : ViewModel(){

    private val _tasksState = mutableStateOf(TasksState())
    val tasksState: State<TasksState> = _tasksState

    private var getTasksJob: Job? = null

    init {
        getTasks()
    }

    fun onEvent(event: TaskUiEvent){
        when(event){
            is TaskUiEvent.OnTaskClick -> {

            }
        }
    }

    private fun getTasks(){
        getTasksJob?.cancel()
        getTasksJob = taskUseCases.getTasks().onEach { tasks ->
            _tasksState.value = tasksState.value.copy(
                tasks = tasks
            )
        }.launchIn(viewModelScope)
    }
}