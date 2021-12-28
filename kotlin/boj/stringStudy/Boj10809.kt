package boj.stringStudy

class Boj10809 {

    /**
     * range를 활용해서 데이터 저장을 할 수 있음 ascii 를 활용해서 저장하거나
     * 코틀린에서 지원해 주는 문자열 range를 활용하면됨 'a'..'z'나 'A'..'Z'를 사용하거나
     * ascii인  'a' (97).. 'z' (122) 'A' (65).. 'Z' (90) 를 사용할 수 있음
     */

    private val alphabets =  mutableMapOf<Char, Int>().apply {
        ('a'..'z').forEach {
            this[it] = -1
        }
    }

    fun isFirst(data: String) : String {
        data.forEachIndexed { index, chars ->
            if(alphabets[chars] == -1) {
               alphabets[chars] = index
            }
        }
        return alphabets.values.joinToString(" ")
    }

    fun run() {
        val testString = "baekjoon"

        println(isFirst(testString))
    }
}