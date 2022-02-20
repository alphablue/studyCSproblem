package programmers.kakao2022

class Recruitment01 {

    private fun solution(id_list: Array<String>, report: Array<String>, k: Int): IntArray {
        var answer = mutableListOf<Int>()
        val reportList = mutableMapOf<String, MutableSet<String>>()
        val countReported = mutableMapOf<String, Int>()
        val isOver = mutableSetOf<String>()

        id_list.forEach {
            reportList += it to mutableSetOf<String>()
            countReported += it to 0
        }

        report.forEach {
            val splits = it.split(" ")

            if((reportList[splits[0]]!! subtract isOver).isEmpty()) {
                reportList[splits[0]]!!.add(splits[1])
                val check = increaseValue(countReported, splits[1], k)

                if (check) {
                    countReported[splits[1]]?.let { count ->
                        if (count >= k) {
                            isOver.add(splits[1])
                        }
                    }
                }
            }
        }

        id_list.forEach {

            val resultCount = (reportList[it]!! intersect isOver).size
            answer.add(resultCount)
        }

        println(answer)
        return answer.toIntArray()
    }

    fun <T> increaseValue(map: MutableMap<T, Int>, key: T, overNum: Int): Boolean {
        var isOver = 0
        when (val count = map[key])
        {
            null -> map[key] = 0
            else -> {
                map[key] = count + 1
                isOver = count + 1
            }
        }

        if(isOver >= overNum)
            return true

        return false
    }

    fun run() {
        val dump1 = arrayOf("muzi", "frodo", "apeach", "neo")
//        val dump1 = arrayOf("con", "ryan")
        val dump2 = arrayOf("muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi")
//        val dump2 = arrayOf("ryan con", "ryan con", "ryan con", "ryan con")
        val dump3 = 2
//        val dump3 = 3
        solution(dump1, dump2, dump3)
    }
}