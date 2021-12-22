package util

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.util.*

class FastReaderKotlin {

    val br = BufferedReader(InputStreamReader(System.`in`))
    var st: StringTokenizer? = null

    fun next(): String {
        while (st == null || !st!!.hasMoreElements()) {
            try {
                st = StringTokenizer(br.readLine())
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        return st!!.nextToken()
    }

    fun nextLine(): String{
        var str: String = ""

        try {
            str = br.readLine()
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return str
    }

    fun nextInt(): Int = next().toInt()

    fun nextLong(): Long = next().toLong()

    fun nextDouble(): Double = next().toDouble()

}