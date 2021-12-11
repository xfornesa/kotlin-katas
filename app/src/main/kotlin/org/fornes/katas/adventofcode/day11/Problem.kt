package org.fornes.katas.adventofcode.day11

import java.util.*


fun solveDay11Problem01(octopus: Array<IntArray>): Int {
    var totalFlashes = 0
    repeat(100) {
        incrementAllValuesByOne(octopus)
        val stepFlashes = iterateFlashes(octopus)
        totalFlashes += stepFlashes
    }

    return totalFlashes
}

fun solveDay11Problem02(octopus: Array<IntArray>): Int {
    var totalSteps = 0
    do {
        totalSteps++
        incrementAllValuesByOne(octopus)
        iterateFlashes(octopus)
    } while (!allFlashes(octopus))

    return totalSteps
}

private fun incrementAllValuesByOne(octopus: Array<IntArray>) {
    val rowLBound = octopus.indices.first
    val rowUBound = octopus.indices.last
    val columnLBound = octopus[rowLBound].indices.first
    val columnUBound = octopus[rowLBound].indices.last
    for (r in rowLBound..rowUBound) {
        for (c in columnLBound..columnUBound) {
            octopus[r][c] = octopus[r][c] + 1
        }
    }
}


private fun iterateFlashes(octopus: Array<IntArray>): Int {
    var stepFlashes = 0
    val flashes = toFlash(octopus)
    while (flashes.isNotEmpty()) {
        val flash = flashes.poll()
        octopus[flash.first][flash.second] = 0
        stepFlashes++

        val neighbours = neighbours(flash, octopus)
        neighbours.forEach {
            val (r, c) = it
            if (octopus[r][c] in 1..9) {
                octopus[r][c] = octopus[r][c] + 1
                if (octopus[r][c] > 9) {
                    flashes.add(it)
                }
            }
        }
    }
    return stepFlashes
}


fun toFlash(octopus: Array<IntArray>): Queue<Pair<Int, Int>> {
    val rowLBound = octopus.indices.first
    val rowUBound = octopus.indices.last
    val columnLBound = octopus[rowLBound].indices.first
    val columnUBound = octopus[rowLBound].indices.last
    val result: Queue<Pair<Int, Int>> = LinkedList()
    for (r in rowLBound..rowUBound) {
        for (c in columnLBound..columnUBound) {
            if (octopus[r][c] > 9) {
                result.add(Pair(r, c))
            }
        }
    }

    return result
}

private fun neighbours(point: Pair<Int, Int>, input: Array<IntArray>): Sequence<Pair<Int, Int>> {
    val rowLBound = input.indices.first
    val rowUBound = input.indices.last
    val columnLBound = input[rowLBound].indices.first
    val columnUBound = input[rowLBound].indices.last
    val (r, c) = point

    return (r - 1..r + 1).flatMap { row: Int -> (c - 1..c + 1).map { column: Int -> Pair(row, column) } }
        .asSequence()
        .filter { it.first >= rowLBound }
        .filter { it.first <= rowUBound }
        .filter { it.second >= columnLBound }
        .filter { it.second <= columnUBound }
}

fun allFlashes(octopus: Array<IntArray>): Boolean {
    return octopus.all { row -> row.all { it == 0 } }
}
