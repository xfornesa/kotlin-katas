package org.fornes.katas.adventofcode.day05

import kotlin.math.abs
import kotlin.math.max


typealias Coordinate = Pair<Int, Int>
typealias Vector = Pair<Coordinate, Coordinate>

fun solveDay05Problem01(input: List<Vector>): Int {
    val matrix = initMatrix(input)
    input.forEach {
        if (isHorizontal(it) || isVertical(it)) {
            drawHorizontalOrVerticalVector(it, matrix)
        }
    }

    return countOverlapping(matrix)
}

fun solveDay05Problem02(input: List<Vector>): Int {
    val matrix = initMatrix(input)
    input.forEach {
        if (isHorizontal(it) || isVertical(it)) {
            drawHorizontalOrVerticalVector(it, matrix)
        }
        if (isDiagonal(it)) {
            drawDiagonalVector(it, matrix)
        }
    }

    return countOverlapping(matrix)

}

private fun maxColumn(input: List<Vector>): Int {
    val maxLeft = input.map { it.first }.map { it.first }.maxOrNull() ?: 0
    val maxRight = input.map { it.second }.map { it.first }.maxOrNull() ?: 0

    return max(maxLeft, maxRight)
}

private fun maxRow(input: List<Vector>): Int {
    val maxLeft = input.map { it.first }.map { it.second }.maxOrNull() ?: 0
    val maxRight = input.map { it.second }.map { it.second }.maxOrNull() ?: 0

    return max(maxLeft, maxRight)
}

private fun initMatrix(input: List<Vector>): Array<IntArray> {
    val maxColumn = maxColumn(input)
    val maxRow = maxRow(input)

    return Array(maxRow + 1) { IntArray(maxColumn + 1) }
}

private fun isHorizontal(vector: Vector): Boolean {
    val coordLeft = vector.first
    val coordRight = vector.second

    return (coordLeft.first == coordRight.first)
}

private fun isVertical(vector: Vector): Boolean {
    val coordLeft = vector.first
    val coordRight = vector.second

    return (coordLeft.second == coordRight.second)
}


private fun isDiagonal(vector: Vector): Boolean {
    val coordLeft = vector.first
    val coordRight = vector.second
    val diffOnX = abs(coordLeft.first - coordRight.first)
    val diffOnY = abs(coordLeft.second - coordRight.second)

    return diffOnX == diffOnY && diffOnX > 0
}

private fun drawHorizontalOrVerticalVector(vector: Vector, matrix: Array<IntArray>) {
    val coordLeft = vector.first
    val coordRight = vector.second

    val columnRange =
        if (coordLeft.first <= coordRight.first) coordLeft.first..coordRight.first else coordLeft.first downTo coordRight.first
    val rowRange =
        if (coordLeft.second <= coordRight.second) coordLeft.second..coordRight.second else coordLeft.second downTo coordRight.second
    for (y in rowRange) {
        for (x in columnRange) {
            matrix[y][x] += 1
        }
    }
}

private fun drawDiagonalVector(vector: Vector, matrix: Array<IntArray>) {
    val coordLeft = vector.first
    val coordRight = vector.second

    val columnStep = if (coordLeft.first <= coordRight.first) 1 else -1
    val rowStep = if (coordLeft.second <= coordRight.second) 1 else -1
    val steps = abs(coordLeft.first - coordRight.first)

    for (i in 0..steps) {
        val x = coordLeft.first + i * columnStep
        val y = coordLeft.second + i * rowStep
        matrix[y][x] += 1
    }
}

private fun countOverlapping(matrix: Array<IntArray>): Int {
    var count = 0
    matrix.forEach { it ->
        it.forEach { it ->
            if (it > 1)
                count++
        }
    }
    return count
}
