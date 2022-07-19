package hu.tb.reminder.domain.use_case

class ValidateTitle {

    fun execute(title: String?): ValidationResult {
        if(title.isNullOrBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = "The title can not be blank"
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}