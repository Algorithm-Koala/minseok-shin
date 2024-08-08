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
    val mans: MutableList<Int> = mutableListOf()

    for (i in 0..8) {
        mans.add(br.readLine().toInt())
    }

    val sum = mans.sum() -100
    var a = 0
    var b = 0

    loop@ for (i in 0..7){
        for (j in i+1..8){
            if(sum==mans[i]+mans[j]){
                a= mans[i]
                b= mans[j]
                break@loop
            }
        }
    }

    mans.remove(a)
    mans.remove(b)

    mans.sort()

    bw.write(mans.joinToString(separator = "\n"))

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
