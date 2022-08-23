package net.ins.edu.algorithms.kt.search

fun main() {
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000), 8))
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000), 1))
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000), 5))
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000), 6))
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000), 7))
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000), 8))
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000, 1001), 1000))
    println(binarySearch(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 11, 567, 1000), 1001))
}

fun binarySearch(arr: IntArray, search: Int, fromIndex: Int = 0, toIndex: Int = arr.size - 1): Int? {
    if (fromIndex <= toIndex) {
        val mid = fromIndex + (toIndex - fromIndex) / 2
        if (arr[mid] == search) return mid
        return if (search > arr[mid])
            binarySearch(arr, search, mid + 1, toIndex)
        else
            binarySearch(arr, search, fromIndex, mid - 1)
    }
    return -1
}