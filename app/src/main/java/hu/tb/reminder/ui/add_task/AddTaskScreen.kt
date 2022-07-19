package hu.tb.reminder.ui.add_task

import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun AddTaskScreen(){

    val viewModel = viewModel<AddTaskScreenViewModel>()
    val state = viewModel.state

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

@Preview
@Composable
fun AddTaskScreenPreview(){
    AddTaskScreen()
}