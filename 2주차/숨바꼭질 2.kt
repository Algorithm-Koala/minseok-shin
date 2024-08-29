package com.example.algorithm_koala
import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (start, end) = br.readLine().split(" ").map { it.toInt() }


    fun bfs(start: Int, end: Int): Pair<Int, Int> {
        val visited = IntArray(100001) { -1 }
        val ways = IntArray(100001) { 0 }
        val queue: Queue<Pair<Int, Int>> = LinkedList()
        queue.offer(Pair(start, 0))
        visited[start] = 0
        ways[start] = 1

        while (queue.isNotEmpty()) {
            val (currentPosition, currentSteps) = queue.poll()

            val nextPositions = listOf(currentPosition + 1, currentPosition - 1, currentPosition * 2)

            for (nextPosition in nextPositions) {
                if (nextPosition in 0..100000) {
                    if (visited[nextPosition] == -1 || visited[nextPosition] == currentSteps + 1) {
                        if (visited[nextPosition] == -1) {
                            queue.offer(Pair(nextPosition, currentSteps + 1))
                            visited[nextPosition] = currentSteps + 1
                        }
                        ways[nextPosition] += ways[currentPosition]
                    }
                }
            }
        }

        return Pair(visited[end], ways[end])
    }

    val (step, way) = bfs(start, end)
    bw.write("$step\n$way")

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()
    // 스트림 닫기
    bw.close()
    br.close()
}
