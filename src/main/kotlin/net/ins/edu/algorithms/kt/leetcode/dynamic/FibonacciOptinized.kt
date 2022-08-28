package net.ins.edu.algorithms.kt.leetcode.dynamic


fun fibonacci(n: Long, cache: MutableMap<Long, Long> = mutableMapOf()): Long {
    if (n <= 2) return 1

    return cache[n]?.let { return@let it } ?: (fibonacci(n-1, cache) + fibonacci(n-2, cache)).also {
        cache[n] = it
    }
}

fun main() {
    println(fibonacci(50)) // 12586269025
}