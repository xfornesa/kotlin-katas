package org.fornes.katas.adventofcode.day01

fun solveDay01Problem01(measures: List<Int>): Int {
    var counter = 0
    var previous = measures[0]
    measures.forEach {
        if (previous < it) {
            counter++
        }
        previous = it
    }
    return counter
}

fun solveDay01Problem02(measures: List<Int>): Int {
    var counter = 0
    var previousSum = measures[0] + measures[1] + measures[2]
    for (i in 3 until measures.size) {
        val currentSum = measures[i - 2] + measures[i - 1] + measures[i]
        if (previousSum < currentSum) {
            counter++
        }
        previousSum = currentSum
    }

    return counter
}
