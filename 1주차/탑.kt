package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import kotlin.math.ceil
import kotlin.math.round
import kotlin.math.sqrt

data class TOP(
    val height:Int,
    val index:Int
)

fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num = br.readLine().toInt()

    val stack = Stack<TOP>()
    stack.push(TOP(0,-1))
    val list = br.readLine().split(" ").map { it.toInt() }

    for (index in list.indices){
        while(stack.isNotEmpty() && stack.peek().height<list[index]){
            stack.pop()
        }
        if (stack.isEmpty()) bw.write("0 ")
        else bw.write("${ stack.peek().index + 1 } ")

        stack.push(TOP(list[index],index))
    }


    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
