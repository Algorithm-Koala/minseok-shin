package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(' ').map { it.toInt() }
    val arr = IntArray(n) { br.readLine().toInt() }.sortedArray()

    repeat(m) {
        val target = br.readLine().toInt()
        var start = 0
        var end = arr.size

        while (start < end) {
            val mid = (start + end) / 2
            if (arr[mid] >= target) end = mid
            else start = mid + 1
        }

        val result = if (start < arr.size && arr[start] == target) start else -1
        bw.write("$result\n")
    }

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
