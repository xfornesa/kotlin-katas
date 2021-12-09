package org.fornes.katas.adventofcode.day09

import java.util.*


fun solveDay09Problem01(input: Array<IntArray>): Int {
    val lowPoints = findLowPoints(input)
    return lowPoints.map { input[it.first][it.second] }.sum() + lowPoints.size
}

private fun findLowPoints(input: Array<IntArray>): MutableList<Pair<Int, Int>> {
    val lowPoints = mutableListOf<Pair<Int, Int>>()
    for (r in input.indices) {
        for (c in input[r].indices) {
            val isLowPoint = neighbours(Pair(r, c), input)
                .map {
                    input[it.first][it.second]
                }
                .all { it > input[r][c] }
            if (isLowPoint) {
                lowPoints.add(Pair(r, c))
            }
        }
    }
    return lowPoints
}

fun solveDay09Problem02(input: Array<IntArray>): Int {
    val lowPoints = findLowPoints(input)
    val basins = lowPoints
        .map { calculateBasinWithFloodFill(it, input) }
//        .map { calculateBasinRecursion(it, input) }
    val largest = basins
        .sorted()
        .takeLast(3)
    return largest
        .reduce(Int::times)
}

fun calculateBasinWithFloodFill(point: Pair<Int, Int>, input: Array<IntArray>): Int {
    val basin = mutableSetOf<Pair<Int, Int>>()
    val queue: Queue<Pair<Int, Int>> = LinkedList()
    queue.add(point)
    basin.add(point)
    while (queue.isNotEmpty()) {
        val current = queue.remove()
        neighbours(current, input)
            .filter { input[it.first][it.second] > input[current.first][current.second] && input[it.first][it.second] != 9 }
            .forEach {
                basin.add(it)
                queue.add(it)
            }
    }

    return basin.size
}

fun calculateBasinRecursion(point: Pair<Int, Int>, input: Array<IntArray>): Int {
    return calculateBasinRecursionImpl(point, input).size
}

fun calculateBasinRecursionImpl(point: Pair<Int, Int>, input: Array<IntArray>): Set<Pair<Int, Int>> {
    val neighbours = neighbours(point, input)
        .filter { input[it.first][it.second] > input[point.first][point.second] && input[it.first][it.second] != 9 }
        .toSet()

    val neighbourhoodBasis = neighbours
        .map { calculateBasinRecursionImpl(it, input) }
        .flatten()

    return setOf(point) + neighbourhoodBasis
}

private fun neighbours(point: Pair<Int, Int>, input: Array<IntArray>): Sequence<Pair<Int, Int>> {
    val rowLBound = input.indices.first
    val rowUBound = input.indices.last
    val columnLBound = input[0].indices.first
    val columnUBound = input[0].indices.last

    return listOf(
        Pair(point.first - 1, point.second),
        Pair(point.first, point.second - 1),
        Pair(point.first, point.second + 1),
        Pair(point.first + 1, point.second)
    )
        .asSequence()
        .filter { it.first >= rowLBound }
        .filter { it.first <= rowUBound }
        .filter { it.second >= columnLBound }
        .filter { it.second <= columnUBound }
}
