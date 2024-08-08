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

    val num = br.readLine().toInt()

    val list = mutableListOf<Int>()

    repeat(num){
        val input = br.readLine().toInt()
        if (input==0){
            list.removeAt(list.lastIndex)
        }else
        {
            list.add(input)
        }
    }
    
    bw.write(list.sum().toString())



    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
