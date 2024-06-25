package com.example.androiddemo.model


data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
){

}

enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING
}

fun main() {
    val event1 = Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0)
    val event2 = Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15)
    val event3 = Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30)
    val event4 = Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60)
    val event5 = Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10)
    val event6 = Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45)

    val events = mutableListOf<Event>(event1, event2, event3, event4, event5, event6)

    // 60분 미만의 이벤트만 모아보기
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("shortEvents count: ${shortEvents.size}")

    // 시간대별 이벤트 갯수 요약보기
    val dayPartGroupList = events.groupBy { it.daypart }
    dayPartGroupList.forEach { dayPart, event ->
        println("${dayPart} : ${event.size} events")
    }

    // 리스트의 마지막 항목 출력
    println("Last event of the day: ${events.last().title}")

    // 확장된 속성 출력
    println("Duration of first event of the day: ${events[0].durationOfEvent}")

}

// Event 데이터클래스를 변경하지 않고 확장하여 속성을 추가하는 방법
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) {
        "short"
    } else {
        "long"
    }