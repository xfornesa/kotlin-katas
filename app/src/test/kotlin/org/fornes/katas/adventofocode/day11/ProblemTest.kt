package org.fornes.katas.adventofocode.day11

import org.fornes.katas.adventofocode.InputReader
import org.fornes.katas.adventofcode.day11.solveDay11Problem01
import org.fornes.katas.adventofcode.day11.solveDay11Problem02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val input = InputReader.asIntMatrix("day11/input01-example.txt")

        val result: Int = solveDay11Problem01(input)
        assertEquals(1656, result)
    }

    @Test
    fun testProblem01WithInput() {
        val input = InputReader.asIntMatrix("day11/input01.txt")

        val result: Int = solveDay11Problem01(input)
        assertEquals(1591, result)
    }

    @Test
    fun testProblem02WithExample() {
        val input = InputReader.asIntMatrix("day11/input02-example.txt")

        val result: Int = solveDay11Problem02(input)
        assertEquals(195, result)
    }

    @Test
    fun testProblem02WithInput() {
        val input = InputReader.asIntMatrix("day11/input02.txt")

        val result: Int = solveDay11Problem02(input)
        assertEquals(314, result)
    }
}