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

    val (n) = br.readLine().split(" ").map { it.toInt() }


    var array = LongArray(n+1)

    array[0]=0
    array[1]=1

    for (i in 2 until array.size){
        array[i]=array[i-1]+array[i-2]
    }


    bw.write(array[n].toString())

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()
    // 스트림 닫기
    bw.close()
    br.close()
}
