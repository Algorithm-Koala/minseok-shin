package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.round


fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num = br.readLine().toInt()

    val list = mutableListOf<Int>()

    repeat(num){
        val input = br.readLine().toInt()
        list.add(input)
    }
    val sortedList = list.sorted()
    val countMap = sortedList.groupingBy { it }.eachCount().toSortedMap()

    // 리스트 값들을 key로 해당 수들의 빈도 수 를 value로 하는 map 생성
    val maxKeys = countMap.filter { it.value == countMap.values.max() }.keys.toList()

    val frequency = if (maxKeys.size==1){
        maxKeys[0]
    }else{
        maxKeys[1]
    }

    bw.write((round(sortedList.sum().toDouble()/sortedList.size)).toInt().toString()+"\n")
    bw.write(sortedList[sortedList.lastIndex/2].toString()+"\n")
    bw.write(frequency.toString()+"\n")
    bw.write((sortedList.max()-sortedList.min()).toString()+"\n")
    
    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
