Task 2

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

fun main(){
    data class Event(
    val title: String,
    val description: String? = null,
    val daypart: String,
    val durationInMinutes: Int,
	)
}