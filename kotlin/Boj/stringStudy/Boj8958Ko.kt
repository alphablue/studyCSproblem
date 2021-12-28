package Boj.stringStudy

import util.FastReaderKotlin

class Boj8958Ko {

    private fun quizSumScore(mark: String): Int {
        var isRight = false
        var result = 0
        var continuous = 1

        mark.forEach {
            when (it) {
                'O' -> {
                    if (isRight) {
                        continuous = continuous.inc()
                        result += continuous
                    } else {
                        isRight = true
                        continuous = 1
                        result += continuous
                    }
                }
                'X' -> isRight = false
            }
        }

        return result
    }

    fun run() {

        val scan = FastReaderKotlin()
        val N = scan.nextInt()
        (1..N).forEach {
            println(quizSumScore(scan.next()))
        }
    }
}

