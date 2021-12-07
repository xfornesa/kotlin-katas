package org.fornes.katas.adventofcode.day07

import java.util.stream.IntStream.range
import kotlin.math.abs


fun solveDay07Problem01(input: List<Int>): Int {
    return solve(input, ::calculateCostConstantly)
}

fun solveDay07Problem02(input: List<Int>): Int {
    return solve(input, ::calculateCostProgressively)
}

private fun solve(input: List<Int>, calculateCost: (position: Int, referencePosition: Int) -> Int): Int {
    var currentPosition = -1
    var currentFuelCost = Int.MAX_VALUE
    var (min, max) = Pair(input.minOrNull() ?: 0, input.maxOrNull() ?: 0)

    range(min, max).forEach { candidatePosition ->
        val candidateFuelCost = input.map { calculateCost(it, candidatePosition) }.sumOf { it }
        if (candidateFuelCost < currentFuelCost) {
            currentPosition = candidatePosition
            currentFuelCost = candidateFuelCost
        }
    }
    return currentFuelCost
}

private fun calculateCostConstantly(it: Int, candidatePosition: Int) = abs(it - candidatePosition)

private fun calculateCostProgressively(position: Int, referencePosition: Int): Int {
    val diff = abs(position - referencePosition)
    val additionalCost = range(1, diff + 1).map { it }.sum()

    return additionalCost
}
