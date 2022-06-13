package boj.stringStudy

class CookBookRegex {
    val regex1 = """(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&*()_+]).{6,13}""".toRegex()

    fun regexTest() {
        println(regex1 matches "123er!")
    }
}

fun main() {
    val cookBook = CookBookRegex()

    cookBook.regexTest()
}