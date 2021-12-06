package org.fornes.katas.adventofcode.day06


fun solveDay06Problem01(input: List<Int>): Long {
    val expectations = mapOf(
        Pair(0, iterate(listOf(0), 80)),
        Pair(1, iterate(listOf(1), 80)),
        Pair(2, iterate(listOf(2), 80)),
        Pair(3, iterate(listOf(3), 80)),
        Pair(4, iterate(listOf(4), 80)),
        Pair(5, iterate(listOf(5), 80)),
        Pair(6, iterate(listOf(6), 80)),
        Pair(7, iterate(listOf(7), 80)),
        Pair(8, iterate(listOf(8), 80)),
    )
    return input.map { expectations[it] ?:0 }.sumOf { it.toLong() }
}

private fun iterate(input: List<Int>, days: Int): Int {
    var result = input
    repeat(days) {
        val childrenToAdd = result.count { it == 0 }
        result = result.map {
            if (it == 0)
                6
            else
                it - 1
        }
        repeat(childrenToAdd) {
            result += 8
        }
    }
    return result.count()
}

fun solveDay06Problem02(input: List<Int>): Long {
    var current: MutableMap<Int, Long> = mutableMapOf()
    input.groupingBy{ it }.eachCount().forEach { it: Map.Entry<Int, Int> ->
        current[it.key] = it.value.toLong()
    }

    repeat(256) {
        val old = current.toMap()
        current = mutableMapOf()
        old.forEach {
            when (it.key) {
                0 -> {
                    current[6] = (current[6]?: 0) + it.value
                    current[8] = (current[8]?: 0) + it.value
                }
                else -> current[it.key-1] = (current[it.key-1]?: 0) + it.value
            }
        }
    }

    return current.map { it.value }.sum()
}
