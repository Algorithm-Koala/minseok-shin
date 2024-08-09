package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.sqrt


fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num = br.readLine().toInt()

    repeat(num){
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        val distance = end-start
        var result = (round(sqrt(distance.toDouble())).toInt())*2-1
        if (round(sqrt(distance.toDouble()))!= ceil(sqrt(distance.toDouble()))){
            result++
            }
        bw.write(result.toString() +"\n")
    }

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
