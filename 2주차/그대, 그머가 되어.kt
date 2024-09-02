package com.example.algorithm

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

    val (a,b) = br.readLine().split(" ").map { it.toInt()-1 }
    val (n, m) = br.readLine().split(" ").map { it.toInt() }


    val graph = Array(n) { IntArray(n) }
    val visited = Array(n) { -1 }

    if (a == b) {
        bw.write("0")
        bw.flush()
        bw.close()
        return
    }

    val queue: Queue<Int> = LinkedList()

    repeat(m) {
        val (x, y) = br.readLine().split(" ").map { it.toInt() - 1 }
        graph[x][y] = 1
        graph[y][x] = 1
    }

    queue.offer(a)
    visited[a]=0

    while (queue.isNotEmpty()) {
        val top = queue.poll()

        repeat(n) { index ->
            if (graph[top][index] == 1 && visited[index] == -1) {
                if (index == b) {
                    bw.write((visited[top] + 1).toString())
                    bw.flush()
                    bw.close()
                    return
                }
                queue.add(index)
                visited[index] = visited[top] + 1
            }
        }
    }



    bw.write((-1).toString())


    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
