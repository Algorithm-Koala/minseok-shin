package com.example.algorithm_koala

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.sqrt



fun main() {
    // 입력
    val br = BufferedReader(InputStreamReader(System.`in`))
    // 출력
    val bw = BufferedWriter(OutputStreamWriter(System.`out`))


    // 입력의 최대 값 설정
    val maxInput = 123456 * 2

    // 에라토스테네스의 체를 사용하여 소수 판별
    val isPrime = BooleanArray(maxInput + 1) { true }
    isPrime[0] = false
    isPrime[1] = false

    for (i in 2..sqrt(maxInput.toDouble()).toInt()) {
        if (isPrime[i]) {
            for (j in i * i..maxInput step i) {
                isPrime[j] = false
            }
        }
    }

    while (true) {
        val input = br.readLine().toInt()
        if (input == 0) {
            break
        }
        var cnt = 0
        for (i in (input + 1)..(2 * input)) {
            if (isPrime[i]) {
                cnt++
            }
        }
        bw.write(cnt.toString() + "\n")
    }

    // 버퍼 비우기, 안하면 시간 초과
    bw.flush()

    // 스트림 닫기
    bw.close()
    br.close()
}
