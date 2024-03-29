package hu.tb.reminder

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import dagger.hilt.android.AndroidEntryPoint
import hu.tb.reminder.ui.add_task.AddTaskScreen
import hu.tb.reminder.ui.task.TaskListScreen
import hu.tb.reminder.ui.theme.ReminderTheme
import hu.tb.reminder.util.Routes

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ReminderTheme {
                val navController = rememberNavController()
                Surface(

                ) {
                    NavHost(
                        navController = navController,
                        startDestination = Routes.TASK_LIST
                    ){
                        composable(
                            route = Routes.TASK_LIST
                        ) {
                            TaskListScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = Routes.ADD_EDIT_TASK
                        ) {
                            AddTaskScreen(

                            )
                        }
                    }
                }

            }
        }
    }
}