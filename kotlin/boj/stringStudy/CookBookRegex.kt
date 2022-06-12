package boj.stringStudy

class CookBookRegex {
    val regex1 = """^([\da-z]+){6,13}&""".toRegex()

    fun regexTest() {
        println(regex1 matches "123123fasd")
    }
}

fun main() {
    val cookBook = CookBookRegex()

    cookBook.regexTest()
}