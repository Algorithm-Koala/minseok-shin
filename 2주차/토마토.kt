package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.Queue
import java.util.StringTokenizer

data class Point(val x: Int, val y: Int)

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val dx = arrayOf(0,0,1,-1)
    val dy = arrayOf(1,-1,0,0)

    val (m, n) = br.readLine().split(" ").map { it.toInt() }

    var day = 0

    val map = Array(n) { Array(m) { 0 } }

    val start:Queue<Point> = LinkedList()

    repeat(n){x->
        val st = StringTokenizer(br.readLine()," ")
        repeat(m){y->
            map[x][y] = st.nextToken().toInt()
            if (map[x][y]==1){
                start.offer(Point(x,y))
            }
        }
    }

    val queue:Queue<Point> = LinkedList()
    start.forEach{queue.offer(it)}

    queue.offer(Point(-1,-1))

    while (queue.isNotEmpty()){
        val next = queue.poll()

        if (next.x == -1 && next.y ==-1){
            day++
            if (queue.isNotEmpty()){
                queue.offer(Point(-1,-1))
            }
        }

        for (i in 0 until 4){
            val nextX = next.x + dx[i]
            val nextY = next.y + dy[i]

            if (nextX !in 0 until n || nextY !in 0 until m || map[nextX][nextY] == 1 || map[nextX][nextY] == -1)
                continue

            map[nextX][nextY] = 1
            queue.offer(Point(nextX, nextY))
        }
    }

    map.forEach {it ->
        it.forEach { it2 ->
            if (it2 == 0) {
                bw.write((-1).toString())
                // 버퍼 비우기, 안하면 시간 초과
                bw.flush()

                // 스트림 닫기
                bw.close()
                br.close()
                return
            }
        }
    }

    bw.write((day-1).toString())


    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
