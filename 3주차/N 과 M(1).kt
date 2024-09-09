package com.example.algorithm

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter


fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))

    val (N, M) = br.readLine().split(" ").map { it.toInt() }

    val arr = IntArray(M)
    val visited = BooleanArray(N)

    fun dfs(cnt:Int){
        if (cnt==M){
            arr.forEach {
                bw.write("$it ")
            }
            bw.newLine()
            return
        }

        for (i in 0 until N){
            if (!visited[i]){
                visited[i] = true
                arr[cnt] = i +1
                dfs(cnt +1)
                visited[i] = false
            }
        }
    }

   dfs(0)

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
