package com.example.algorithm_koala

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

data class Size(
    val weight : Int,
    val height : Int,
    var rank : Int
)

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num = br.readLine().toInt()

    var sizeList = mutableListOf<Size>()

    for (i in 1..num){
        var input = br.readLine().split(" ")
        var size = Size(input[0].toInt(), input[1].toInt(),1)
        sizeList.add(size)
    }

    for (i in 0..<num){
        for (j in 0..<num){
            if (sizeList[i].height<sizeList[j].height && sizeList[i].weight<sizeList[j].weight){
                sizeList[i].rank++
            }
        }
    }

    sizeList.forEach {
        bw.write("${it.rank} ")
    }

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
