package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Locale
import java.util.Stack
import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.sqrt


fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m, v) = br.readLine().split(" ").map { it.toInt() }

    val graph = Array(n) { IntArray(n) }
    val visited = BooleanArray(n)

    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() }
        graph[x - 1][y - 1] = 1
        graph[y - 1][x - 1] = 1
    }

    fun dfs(n: Int, v: Int) {
        bw.write("${v+1} ")
        visited[v] = true

        for (i in 0 until n) {
            if (graph[v][i] == 1 && !visited[i]) dfs(n, i)
        }
    }

    fun bfs(n: Int, v: Int) {
        val list = LinkedList<Int>()

        list.add(v)
        visited[v] = true
        bw.write("${v+1} ")

        while (list.isNotEmpty()) {
            val head = list.poll()

            for (i in 0 until n) {
                if (graph[head!!][i] == 1 && !visited[i]) {
                    list.add(i)
                    visited[i] = true
                    bw.write("${i+1} ")

                }
            }
        }
    }

    visited.fill(false)
    dfs(n, v - 1)
    bw.write("\n")
    visited.fill(false)
    bfs(n, v - 1)


    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
