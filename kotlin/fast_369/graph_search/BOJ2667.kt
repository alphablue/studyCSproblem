package fast_369.graph_search

import java.text.SimpleDateFormat
import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.util.*
import java.util.concurrent.TimeUnit

class BOJ2667 {

    fun run() {
        val formatter = DateTimeFormatter.ofPattern("yyyyMMdd")
        val today: LocalDate = LocalDate.now()
        val date: LocalDate = LocalDate.parse("20201122",formatter)
        println(date)
        println(today)

        println(Period.between(
            date,
            today
        ))

        val test = Array<Int>(10){ data-> data + 1}
        println(test)


    }
}

fun main() {
    BOJ2667().run()
}