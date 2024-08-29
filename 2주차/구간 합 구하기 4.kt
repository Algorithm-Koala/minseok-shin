package com.example.algorithm_koala

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (n, m) = br.readLine().split(" ").map { it.toInt() }
    // nums 배열 맨 앞에 0 추가
    val nums = (listOf(0) + br.readLine().split(" ").map { it.toInt() }).toMutableList()

    // 누적합 계산
    for (i in 1 until nums.size) {
        nums[i] = nums[i - 1] + nums[i]
    }

    repeat(m) {
        val (a, b) = br.readLine().split(" ").map { it.toInt() }
        val result = nums[b] - nums[a - 1]
        bw.write(result.toString() + "\n")
    }

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()
    // 스트림 닫기
    bw.close()
    br.close()
}

