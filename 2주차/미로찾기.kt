package com.example.algorithm_koala

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import kotlin.math.sqrt

data class Location(val x: Int, val y: Int)

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n,m) = br.readLine().split(" ").map { it.toInt() }

    val dx = arrayOf(1,-1,0,0)
    val dy = arrayOf(0,0,1,-1)

    val visited = Array(n) { IntArray(m) }
    val graph = Array(n) { br.readLine().map { it.toString().toInt() }.toIntArray() }

    val queue : Queue<Location> = LinkedList()
    queue.offer(Location(0, 0))
    visited[0][0] = 1

    while (queue.isNotEmpty()) {
        val tmp = queue.poll()

        for (index in dx.indices) {
            val nextX = tmp.x + dx[index]
            val nextY = tmp.y + dy[index]
            if (0 > nextX ||nextX >= n || 0 > nextY || nextY >= m) continue

            if (graph[nextX][nextY] == 1 && visited[nextX][nextY] == 0) {
                queue.offer(Location(nextX, nextY))
                visited[nextX][nextY] = visited[tmp.x][tmp.y] + 1
            }
        }
    }

    bw.write(visited[n - 1][m - 1].toString())

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
