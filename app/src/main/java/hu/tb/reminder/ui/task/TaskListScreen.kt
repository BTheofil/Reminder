package hu.tb.reminder.ui.task

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Scaffold
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import hu.tb.reminder.util.UiEvent
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TaskListScreen(
    onNavigate: (UiEvent.Navigate) -> Unit,
    viewModel: TaskViewModel = hiltViewModel()
) {
    val tasksState = viewModel.tasksState.value
    val scaffoldState = rememberScaffoldState()
    
    Scaffold(
        scaffoldState = scaffoldState
    ) {
        LazyColumn(){
            items(tasksState.tasks) { task ->
                TaskItem(
                    task = task,
                    onEvent = viewModel::onEvent,
                    modifier = Modifier
                        .fillMaxSize()
                        .clickable {
                            viewModel.onEvent(TaskListEvent.OnTaskClick(task))
                        }
                )
            }
        }
    }
}

@Preview
@Composable
fun TaskListScreenPreview(){
    TaskListScreen(onNavigate = {})
}