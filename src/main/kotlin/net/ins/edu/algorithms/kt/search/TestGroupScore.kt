@file:Suppress("UNREACHABLE_CODE")

package net.ins.edu.algorithms.kt.search

fun solution(tests: Array<String>, results: Array<String>): Int {
    val regex = "^([A-Za-z]*)(\\d*)".toRegex()
    val testGroups = mutableSetOf<String>()
    val testsByIndexes = mutableMapOf<String, Int>()

    val testsByGroups = mutableMapOf<String, MutableSet<Pair<String, Boolean>>>()

    tests.forEachIndexed { idx, test ->
        testsByIndexes[test] = idx
        val find = regex.find(test)
        find?.groupValues?.get(0)?.let {
            testGroups += it + find.groupValues.get(1)
            val groupTests = testsByGroups[it] ?: mutableSetOf()
            groupTests += test to (results[idx].toLowerCase() == "ok")
            testsByGroups[it] = groupTests
        }
    }

    val fullyPassedGroups = testsByGroups.count { group ->
        group.value.count { groupTests -> groupTests.second } == group.value.size
    }

    return fullyPassedGroups * 100 / testGroups.size
}

fun main() {
    println(solution(arrayOf("test1a", "test1b", "test", "sample", "fuck1a", "fuck", "fuck1b"), arrayOf("OK", "failed", "fuck off", "OK", "OK", "OK", "OK")))
    println(solution(arrayOf("test1a", "test2", "test1b", "test1c", "test3"), arrayOf("Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded")))
}



