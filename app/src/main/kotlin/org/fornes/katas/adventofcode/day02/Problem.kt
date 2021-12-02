package org.fornes.katas.adventofcode.day02

fun solveDay02Problem01(measures: List<Pair<String, Int>>): Int {
    var horizontalPosition = 0
    var depth = 0
    measures.forEach {
        val (movement, units) = it
        when (movement) {
            "forward" -> horizontalPosition += units
            "down" -> depth += units
            "up" -> depth -= units
        }
    }

    return horizontalPosition * depth
}

fun solveDay02Problem02(measures: List<Pair<String, Int>>): Int {
    var horizontalPosition = 0
    var depth = 0
    var aim = 0
    measures.forEach {
        val (movement, units) = it
        when (movement) {
            "forward" -> {
                horizontalPosition += units
                depth += aim * units
            }
            "down" -> aim += units
            "up" -> aim -= units
        }
    }

    return horizontalPosition * depth
}
