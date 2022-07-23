package hu.tb.reminder.ui.add_task

import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun AddTaskScreen(
    viewModel: AddTaskScreenViewModel = hiltViewModel()
){
    val state = viewModel.state
    val scaffoldState = rememberScaffoldState()

    Scaffold(
        scaffoldState = scaffoldState,
    ) {
        OutlinedTextField(
            value = state.title,
            onValueChange = { viewModel.onEvent(ValidationEvent.TitleChanged(it)) },
            label = { Text("Title") },
        )

        Button(
            onClick = {
                viewModel.onEvent(ValidationEvent.Submit)
            },
        ) {
            Text(text = "Submit")
        }
    }

}

@Preview
@Composable
fun AddTaskScreenPreview(){
    AddTaskScreen()
}