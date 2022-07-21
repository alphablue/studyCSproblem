package boj.stringStudy

import java.util.Scanner

class CookBookRegex {
    val regex1 = """(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+]).{6,13}""".toRegex()

    fun regexTest() {
        println(regex1 matches "123er!")
        val test = (0..40).toList()
        println(test.subList(1, 3))


    }
}

fun main() {
    val cookBook = CookBookRegex()

    cookBook.regexTest()
}