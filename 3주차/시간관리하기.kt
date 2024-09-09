package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Task(var start:Int, var end: Int)

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val N = br.readLine().toInt()

    val tasks = mutableListOf<Task>()

    repeat(N) {
        val (duration, dueTime) = br.readLine().split(" ").map{it.toInt()}
        val task = Task(dueTime-duration,dueTime-1)
        tasks.add(task)
    }

    tasks.sortByDescending { it.end }

    var nextTask = tasks[0]

    for (i in 1 until N) {
        val currentTask = tasks[i]


        if (currentTask.end >= nextTask.start){
            val moveToLeft = currentTask.end - nextTask.start + 1
            currentTask.end -= moveToLeft
            currentTask.start -= moveToLeft
        }


        if (currentTask.start < 0) {
            print(-1)
            return
        }

        nextTask = currentTask
    }

    bw.write(tasks.last().start.toString())

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
