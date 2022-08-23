package net.ins.edu.algorithms.kt.leetcode

class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var result = ""

        s.forEachIndexed { index, c ->
            val candidate = moveOn(s, index)
            result = if (candidate.length > result.length) candidate else result
        }

        return result.length
    }

    fun moveOn(s: String, from: Int = 0): String {
        var str = ""
        var previous = mutableSetOf<Char>()

        s.substring(from).forEachIndexed { index, c ->
            if (c in previous) {
                return str
            } else {
                previous.add(c)
                str += c
            }
        }
        return str
    }
}

fun main() {
//    println(Solution().lengthOfLongestSubstring("abcabcbb"))
//    println(Solution().lengthOfLongestSubstring("bbbbb"))
//    println(Solution().lengthOfLongestSubstring("pwwkew"))
    println(Solution().lengthOfLongestSubstring("a"))
    println(Solution().lengthOfLongestSubstring(" "))
}