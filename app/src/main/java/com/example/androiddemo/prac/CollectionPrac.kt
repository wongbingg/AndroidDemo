package com.example.androiddemo.prac

class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double
)

val cookies = listOf(
    Cookie(
        name = "Chocolate Chip",
        softBaked = false,
        hasFilling = false,
        price = 1.69
    ),
    Cookie(
        name = "Banana Walnut",
        softBaked = true,
        hasFilling = false,
        price = 1.49
    ),
    Cookie(
        name = "Vanilla Creme",
        softBaked = false,
        hasFilling = true,
        price = 1.59
    ),
    Cookie(
        name = "Chocolate Peanut Butter",
        softBaked = false,
        hasFilling = true,
        price = 1.49
    ),
    Cookie(
        name = "Snickerdoodle",
        softBaked = true,
        hasFilling = false,
        price = 1.39
    ),
    Cookie(
        name = "Blueberry Tart",
        softBaked = true,
        hasFilling = true,
        price = 1.79
    ),
    Cookie(
        name = "Sugar and Sprinkles",
        softBaked = false,
        hasFilling = false,
        price = 1.39
    )
)

fun main() {
    // 일반적인 배열 선언
    // gasPlanets[3] 으로 인덱스 접근 가능
    val gasPlanets = arrayOf("Jupiter", "Saturn", "Uranus", "Neptune")

    // List 선언
    // [index] 또는 .get(index) 로 요소 접근 가능
    // .indexOf("Mercury") -> 해당 요소의 인덱스 반환
    val solarSystem1 = listOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")


    // MutableList 선언
    // List 를 확장한 함수
    // .add(삽입) , .remove(삭제) 동작 가능
    val solarSystem2 = mutableListOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")


    // MutualSet 선언 (집합)
    // Set 을 확장한 함수
    val solarSystem3 = mutableSetOf("Mercury", "Venus", "Earth", "Mars", "Jupiter", "Saturn", "Uranus", "Neptune")


    // MutualMap 선언 (딕셔너리)
    // 크기가 큰 컬렉션에서는 값을 찾을 때 리스트보다 빠르다.
    val solarSystem4 = mutableMapOf(
        "Mercury" to 0,
        "Venus" to 0,
        "Earth" to 1,
        "Mars" to 2,
        "Jupiter" to 79,
        "Saturn" to 82,
        "Uranus" to 27,
        "Neptune" to 14
    )

    // ------------------- 고차함수 -------------------------------------------

    // forEach
    cookies.forEach {
        // 문자열 보간법
        println("Menu item : ${it.name}")
    }

    // map
    val fullMenu = cookies.map {
        "${it.name} - $${it.price}"
    }
    println(fullMenu)

    // filter
    val softBakedCookies = cookies.filter {
        // 내부 스코프 조건식이 true일 때만 값을 통과
        it.softBaked
    }

    // groupBy
    val groupedMenu = cookies.groupBy { it.softBaked }
    val softBakedMenu = groupedMenu[true] ?: listOf()
    val crunchyMenu = groupedMenu[false] ?: listOf()

    // fold (swift 의 reduce 와 동일 )
    val totalPrice = cookies.fold(0.0) { total, cookie ->
        total + cookie.price
    }
    println(totalPrice)

    // sortedBy (정렬)
    val alphabeticalMenu = cookies.sortedBy {
        it.name
    }
}