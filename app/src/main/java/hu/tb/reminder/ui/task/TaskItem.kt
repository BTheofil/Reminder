package hu.tb.reminder.ui.task

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Checkbox
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import hu.tb.reminder.domain.model.Category
import hu.tb.reminder.domain.model.Task
import java.time.LocalDateTime
import java.util.*

@Composable
fun TaskItem(
    task: Task,
    onEvent: (TaskListEvent) -> Unit = {},
    modifier: Modifier = Modifier
) {
    Column(

    ) {
        Row(

        ) {
            Text(
                text = task.title,
                fontSize = 20.sp
            )
            Checkbox(
                checked = task.isDone,
                onCheckedChange = { isChecked ->
                    onEvent(TaskListEvent.OnDoneChange(task, isChecked))
                }
            )
        }
    }
}

@Preview
@Composable
fun TaskItemPreview() {
    TaskItem(
        task = Task(
            title = "Test",
            description = "test",
            //remindTime = Calendar.getInstance().time,
            isDone = false,
            coverImage = "",
            category = Category.DAILY
        ),
    )
}