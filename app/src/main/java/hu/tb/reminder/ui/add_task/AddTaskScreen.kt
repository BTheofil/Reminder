package hu.tb.reminder.ui.add_task

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 32.dp),
            verticalArrangement = Arrangement.Center,
        ) {
            OutlinedTextField(
                value = state.title,
                onValueChange = { viewModel.onEvent(ValidationEvent.TitleChanged(it)) },
                label = { Text("Title") },
                modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(8.dp))
            Button(
                modifier = Modifier
                    .align(Alignment.End),
                onClick = {
                    viewModel.onEvent(ValidationEvent.Submit)
                },
            ) {
                Text(text = "Submit")
            }
        }

    }

}

@Preview
@Composable
fun AddTaskScreenPreview(){
    AddTaskScreen()
}