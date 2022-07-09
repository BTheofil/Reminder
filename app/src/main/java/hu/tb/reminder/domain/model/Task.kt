package hu.tb.reminder.domain.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.Date

@Entity
data class Task(
    @PrimaryKey val id: Int? = null,
    val title: String,
    val description: String?,
    val remindTime: Date,
    val isItDone: Boolean,
    val coverImage: String,
    val category: Category
)
