package programmers.school_0

import java.util.Collections
import kotlin.math.pow
import kotlin.math.sqrt
import kotlin.reflect.jvm.internal.impl.utils.CollectionsKt
import kotlin.time.times
import kotlin.time.toDuration


/**
 * 나머지를 구하는 아주 간단한 문제 단 지레 짐작해 문제에서 num1 을 num2 를 나누는 것인데
 * 큰수를 작은수로 나누는 것으로 생각하면 안된다.
 * */
fun main(){

    val num1: Int = 5
    val num2: Int = 3
    val test = intArrayOf(1,2,3)

    var result = 2.toDouble().pow(15)*7
    val tt = StringBuffer()
    println(num2 / num1)

    var result2 = "aabvb32123".toList().sorted()
    val ddsds = test.toMutableList()
    println(ddsds.toString())
    println(result2.elementAt(0))

    val testArray = listOf(3, 2, 7, 4, 8, 1, 2, 3, 4, 5)
    val ddddf = intArrayOf(1, 3, 5)
    val ttt = testArray.sortedDescending().run { if(this.sum()>(this.first()*2)) 1 else 0}
    val ddd = mutableSetOf<Int>()

    println(testArray.subList(5, testArray.size))

    println(ddddf)
}