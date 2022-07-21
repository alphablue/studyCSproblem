package fast_369.graph_search

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.LinkedList
import java.util.Queue


class BOJ1260 {
    private val inputData: MutableList<Int> = mutableListOf()
    private val matrix: MutableList<IntArray> = mutableListOf()
    var visited = booleanArrayOf()
    private val que: Queue<Int> = LinkedList()

    fun run() {
        val keyReader = BufferedReader(InputStreamReader(System.`in`))

        inputData.addAll( keyReader.readLine().split(" ").map { it.toInt() })
        matrix.addAll(Array(inputData.first()) { IntArray(inputData.first()) })
        visited = BooleanArray(inputData.first())


        repeat(inputData.first()) {
            val xy = keyReader.readLine().split(" ").map{
                it.toInt()
            }

            matrix[xy[0] - 1][xy[1] - 1] = 1
            matrix[xy[1] - 1][xy[0] - 1] = 1
        }

        visited.fill(false)
        dfs(inputData[2] - 1)

        println()
        visited.fill(false)
        bfs(inputData[2] - 1)
    }

    private fun dfs(v: Int) {
        visited[v] = true
        print("${v + 1} ")

        for (i in 0 until inputData[0]) {
            if (matrix[v][i] == 1 && !visited[i])
                dfs(i)
        }

    }

    private fun bfs(v: Int) {
        val list: LinkedList<Int> = LinkedList()
        list.add(v)
        visited[v] = true
        print("${v + 1} ")

        while (list.isNotEmpty()) {
            val now = list.poll()

            for (i in 0 until inputData[0]) {
                if (matrix[now][i] == 1 && !visited[i]) {
                    list.add(i)
                    visited[i] = true
                    print("${i + 1} ")
                }
            }
        }
    }
}

fun main() {
    BOJ1260().run()
}