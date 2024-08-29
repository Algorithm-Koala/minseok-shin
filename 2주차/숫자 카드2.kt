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

    val n = br.readLine().toInt()
    val cardList = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val m = br.readLine().toInt()
    val cards = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    val count = mutableMapOf<Int, Int>()

    cardList.forEach {
        count[it] = count.getOrDefault(it, 0) + 1
    }

    val result = cards.map { count.getOrDefault(it, 0) }
    bw.write(result.joinToString(" "))

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
