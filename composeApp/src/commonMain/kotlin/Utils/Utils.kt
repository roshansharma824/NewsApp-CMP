package Utils


import kotlinx.datetime.*
import kotlinx.datetime.TimeZone
import kotlin.time.Duration
import kotlin.time.Duration.Companion.hours
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun calculateTimeDifference(dateString: String): String {
    // Parse the input date string to an Instant
//    val formatter = DateTimeFormatter.ISO_OFFSET_DATE_TIME
    val inputDate = Instant.parse(dateString)

    // Get the current date and time in the system default time zone
    val currentDate = Clock.System.now()

    // Convert both instants to LocalDateTime in the system time zone
    val systemTimeZone = TimeZone.currentSystemDefault()
    val inputDateTime = inputDate.toLocalDateTime(systemTimeZone)
    val currentDateTime = currentDate.toLocalDateTime(systemTimeZone)

    // Calculate the difference in years, months, days, hours, minutes, and seconds
    val years = currentDateTime.year - inputDateTime.year
    val months = currentDateTime.monthNumber - inputDateTime.monthNumber
    val days = currentDateTime.dayOfMonth - inputDateTime.dayOfMonth
    val hours = currentDateTime.hour - inputDateTime.hour
    val minutes = currentDateTime.minute - inputDateTime.minute
    val seconds = currentDateTime.second - inputDateTime.second

    return "$years years, $months months, $days days, $hours hours, $minutes minutes, $seconds seconds"
}


fun calculateTimeDifferenceInHoursAndMinutes(dateString: String): String {
    // Parse the input date string to an Instant
    val inputDate = Instant.parse(dateString)

    // Get the current date and time in the system default time zone
    val currentDate = Clock.System.now()

    // Calculate the difference in hours and minutes
    val duration = currentDate - inputDate
    val hoursDifference = duration.inWholeHours
    val remainingMinutes = (duration - hoursDifference.hours).inWholeMinutes

    return "$hoursDifference:$remainingMinutes"
}


