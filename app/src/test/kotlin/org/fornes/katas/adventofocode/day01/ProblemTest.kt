package org.fornes.katas.adventofocode.day01

import org.fornes.katas.adventofocode.InputReader
import org.fornes.katas.adventofcode.day01.solveDay01Problem01
import org.fornes.katas.adventofcode.day01.solveDay01Problem02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val measures = listOf(
            199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263
        )
        val result: Int = solveDay01Problem01(measures)
        assertEquals(7, result)
    }

    @Test
    fun testProblem01WithInput() {
        val measures = InputReader.asListOfInts("day01/input01.txt")

        val result: Int = solveDay01Problem01(measures)
        assertEquals(1766, result)
    }

    @Test
    fun testProblem02WithExample() {
        val measures = listOf(
            199,
            200,
            208,
            210,
            200,
            207,
            240,
            269,
            260,
            263
        )
        val result: Int = solveDay01Problem02(measures)
        assertEquals(5, result)
    }

    @Test
    fun testProblem02WithInput() {
        val measures = InputReader.asListOfInts("day01/input02.txt")

        val result: Int = solveDay01Problem02(measures)
        assertEquals(1797, result)
    }
}