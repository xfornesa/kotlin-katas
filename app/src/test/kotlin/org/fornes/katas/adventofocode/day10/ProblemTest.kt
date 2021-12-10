package org.fornes.katas.adventofocode.day10

import org.fornes.katas.adventofcode.day10.solveDay10Problem01
import org.fornes.katas.adventofcode.day10.solveDay10Problem02
import org.fornes.katas.adventofocode.InputReader
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val input = InputReader.asListOfStrings("day10/input01-example.txt")

        val result: Long = solveDay10Problem01(input)
        assertEquals(26397, result)
    }

    @Test
    fun testProblem01WithInput() {
        val input = InputReader.asListOfStrings("day10/input01.txt")

        val result: Long = solveDay10Problem01(input)
        assertEquals(392367, result)
    }

    @Test
    fun testProblem02WithExample() {
        val input = InputReader.asListOfStrings("day10/input02-example.txt")

        val result: Long = solveDay10Problem02(input)
        assertEquals(288957, result)
    }

    @Test
    fun testProblem02WithInput() {
        val input = InputReader.asListOfStrings("day10/input02.txt")

        val result: Long = solveDay10Problem02(input)
        assertNotEquals(454057517, result)
        assertNotEquals(514512498, result)
        assertEquals(2192104158, result)
    }
}