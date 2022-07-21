package fast_369.graph_search

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

class BOJ1260My {

    private val matrixMap = mutableMapOf<Int, MutableList<Int>>()
    private lateinit var visited: BooleanArray

    fun run() {
        val keyReader = BufferedReader(InputStreamReader(System.`in`))

        // 정점의 갯수, 간선의 개수, 시작할 정점
        val getCondition = keyReader.readLine().split(" ").map { it.toInt() }
        val V = getCondition.first() + 1
        val E = getCondition[1]
        val startV = getCondition.last()

        /**
         * 조건에 맞는 데이터 공간을 초기화 하는 것
         * */
        visited = BooleanArray(V)
        repeat(V) {
            matrixMap[it] = mutableListOf()
        }

        /**
         * 데이터 공간에 정보를 담는 과정
         * */
        repeat(E){
            val vTov = keyReader.readLine().split(" ").map { it.toInt() }

            /**
             * 단방향이 아닌 양방향이기 때문에 동시에 채워줘야함
             * */
            matrixMap[vTov.first()]?.add(vTov[1])
            matrixMap[vTov[1]]?.add(vTov[0])
        }

        matrixMap.forEach { (_, u) ->
            u.sort()
        }

        visited.fill(false)
        dfs(startV)
        println()

        visited.fill(false)
        bfs(startV)
    }

    private fun dfs(startEdge: Int) {
        visited[startEdge] = true
        print("$startEdge ")

        matrixMap[startEdge]?.let {
            for(idx in it) {
                if (visited[idx])
                    continue

                dfs(idx)
            }
        }
    }

    private fun bfs(startEdge: Int) {
        val queue: Queue<Int> = LinkedList()

        queue.add(startEdge)

        while(queue.isNotEmpty()) {
            val now = queue.poll()
            if(visited[now])
                continue

            visited[now] = true
            print("$now ")

            matrixMap[now]?.let {
                queue.addAll(it)
            }
        }

    }
}

fun main() {
    BOJ1260My().run()
}