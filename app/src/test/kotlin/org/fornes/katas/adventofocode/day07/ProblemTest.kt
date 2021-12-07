package org.fornes.katas.adventofocode.day07

import org.fornes.katas.adventofocode.InputReader
import org.fornes.katas.adventofcode.day07.solveDay07Problem01
import org.fornes.katas.adventofcode.day07.solveDay07Problem02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val input = InputReader.asListOfInts("day07/input01-example.txt")

        val result: Int = solveDay07Problem01(input)
        assertEquals(37, result)
    }

    @Test
    fun testProblem01WithInput() {
        val input = InputReader.asListOfInts("day07/input01.txt")

        val result: Int = solveDay07Problem01(input)
        assertEquals(352254, result)
    }

    @Test
    fun testProblem02WithExample() {
        val input = InputReader.asListOfInts("day07/input02-example.txt")

        val result: Int = solveDay07Problem02(input)
        assertEquals(168, result)
    }

    @Test
    fun testProblem02WithInput() {
        val input = InputReader.asListOfInts("day07/input02.txt")

        val result: Int = solveDay07Problem02(input)
        assertEquals(99053143, result)
    }
}