package Boj

import util.FastReaderKotlin
import kotlin.math.max
import kotlin.math.min

class Boj14888Ko {

    var N: Int = 0
    var max = Int.MIN_VALUE
    var min = Int.MAX_VALUE
    var sb = StringBuilder()

    private val nums = mutableListOf<Int>(0)
    private val operator = MutableList(5) { 0 }

    private fun input() {
//        val scan = Scanner(System.`in`)
        val scan = FastReaderKotlin()
        N = scan.nextInt()
        (1..N).forEach { _ -> nums.add(scan.nextInt()) }
        (1..4).forEach { operator[it] = scan.nextInt() }
    }

    private fun calculator(operand1: Int, operator: Int, operand2: Int): Int = when (operator) {
        1 -> operand1 + operand2
        2 -> operand1 - operand2
        3 -> operand1 * operand2
        else -> operand1 / operand2
    }

    private fun rec_fun(n: Int, value: Int) {
        if (n == N) {
            max = max(max, value)
            min = min(min, value)
        } else {
            for(idx in 1..4) {
                if (operator[idx] >= 1) {
                    operator[idx] = operator[idx].dec()
                    rec_fun(n + 1, calculator(value, idx, nums[n+1]))
                    operator[idx] = operator[idx].inc()
                }
            }
        }
    }

    fun run() {
        input()
        rec_fun(1, nums[1])
        sb.append(max).append('\n').append(min)
        println(sb.toString())
    }

}