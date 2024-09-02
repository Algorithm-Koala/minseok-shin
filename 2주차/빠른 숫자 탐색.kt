package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue

data class Point(val x: Int, val y: Int)

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val map = Array(5) { br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    val visited = Array(5) { IntArray(5) {-1} }

    val dx = arrayOf(0, 0, -1, 1)
    val dy = arrayOf(-1, 1, 0, 0)

    val queue: Queue<Point> = LinkedList()

    //시작 위치 설정
    queue.offer(Point(r,c))
    visited[r][c]=0

    while (queue.isNotEmpty()){
        val top = queue.poll()

        for (i in 0 until 4){
            val next = Point(top.x+dx[i],top.y+dy[i])
            if (next.x !in 0 until 5 || next.y !in 0 until 5 ) continue

            if (map[next.x][next.y] == 1) {
                bw.write((visited[top.x][top.y] + 1).toString())
                bw.flush()
                bw.close()
                return
            }

            if (map[next.x][next.y] != -1 && visited[next.x][next.y] == -1) {
                queue.add(next)
                visited[next.x][next.y] = visited[top.x][top.y] + 1
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
