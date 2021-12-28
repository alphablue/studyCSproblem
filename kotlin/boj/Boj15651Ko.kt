package boj

import java.util.*
import kotlin.properties.Delegates

class Boj15651Ko {

    private var N by Delegates.notNull<Int>()
    private var M by Delegates.notNull<Int>()
    private var selected by Delegates.notNull<MutableList<Int>>()
    private var list = StringBuilder()

    private fun input() {
        val scan = Scanner(System.`in`)
        N = scan.nextInt()
        M = scan.nextInt()
        selected = MutableList(M + 1) { 0 }
    }

    private fun recFunc(k: Int) {
        if (k == M + 1) {
            for (i in 1..M) list.append(selected[i]).append(" ")
            list.append("\n")
        } else {
            for (i in 1..N) {
                selected[k] = i

                recFunc(k + 1)
                selected[k] = 0
            }
        }
    }

    fun run() {
        input()

        recFunc(1)
        println(list)
    }

}