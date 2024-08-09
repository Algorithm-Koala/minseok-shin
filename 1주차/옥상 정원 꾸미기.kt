package com.example.algorithm_koala

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.util.Stack
import kotlin.math.sqrt



fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val num = br.readLine().toInt()

    val stack = Stack<Long>()
    var cnt = 0L

    repeat(num){
        var building = br.readLine().toLong()
        while (stack.isNotEmpty()&&stack.peek()<=building){
         stack.pop()
        }
        cnt+=stack.size
//        bw.write(stack.size.toString()+"\n")
        stack.push(building)
    }

    bw.write(cnt.toString())

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
