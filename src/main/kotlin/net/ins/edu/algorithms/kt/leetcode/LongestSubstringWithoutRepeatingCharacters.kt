package net.ins.edu.algorithms.kt.leetcode

class Solution {

    fun lengthOfLongestSubstring(s: String): Int {
        var result = ""
        var curIdx = 0
        val idx = 0
        var curCandidateLen = 0

        do {
            val candidate = moveOn(s, curIdx + idx - curCandidateLen + 1)
            curIdx += candidate.first // wrong
            val res = candidate.second
            result = if (res.length > result.length) res else result
            curCandidateLen = result.length
            if (candidate.first < 0) break
        } while (curIdx <= s.length)

        return result.length
    }

    fun moveOn(s: String, from: Int = 0): Pair<Int, String> {
        var str = ""
        val previous = mutableSetOf<Char>()
        if (s.length <= 1) return -1 to s

        s.substring(from).forEachIndexed { index, c ->
            if (c in previous) {
                return index to str
            } else {
                previous.add(c)
                str += c
            }
        }
        return -1 to str
    }
}

fun main() {
    println(Solution().lengthOfLongestSubstring("abcabcbb"))
    println(Solution().lengthOfLongestSubstring("bbbbb"))
    println(Solution().lengthOfLongestSubstring("pwwkew"))
    println(Solution().lengthOfLongestSubstring("a"))
    println(Solution().lengthOfLongestSubstring(" "))
    println(Solution().lengthOfLongestSubstring("dvdf"))
    println(Solution().lengthOfLongestSubstring("anviaj"))
    println(Solution().lengthOfLongestSubstring(""))
    println(Solution().lengthOfLongestSubstring("au"))
    println(Solution().lengthOfLongestSubstring("aud"))
    println(Solution().lengthOfLongestSubstring("audi"))
}