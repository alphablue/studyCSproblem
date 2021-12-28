package Boj.stringStudy

import util.FastReaderKotlin

class Boj1152Ko {

    val regex = """(?= )?[a-zA-Z]+(?= )?"""

    val testString = arrayOf(
        " The First Character is a blank ",
        " The Curious Case of Benjamin Button",
        "The last character is a blank "
        )

    fun countWord(datas: String): Int {
        return Regex(regex).findAll(datas).count()
    }

    fun run() {
        val scan = FastReaderKotlin()
        val data = scan.nextLine()

        testString.forEach {
            println(countWord(it))
        }

        println(data)
        println(countWord(data))
    }
}