package org.fornes.katas.adventofocode.day05

import org.fornes.katas.adventofcode.day05.solveDay05Problem01
import org.fornes.katas.adventofcode.day05.solveDay05Problem02
import org.fornes.katas.adventofocode.InputReader
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val input = InputReader.asListOfVectors("day05/input01-example.txt")

        val result: Int = solveDay05Problem01(input)
        assertEquals(5, result)
    }

    @Test
    fun testProblem01WithInput() {
        val input = InputReader.asListOfVectors("day05/input01.txt")

        val result: Int = solveDay05Problem01(input)
        assertEquals(8350, result)
    }

    @Test
    fun testProblem02WithExample() {
        val input = InputReader.asListOfVectors("day05/input02-example.txt")

        val result: Int = solveDay05Problem02(input)
        assertEquals(12, result)
    }

    @Test
    fun testProblem02WithInput() {
        val input = InputReader.asListOfVectors("day05/input02.txt")

        val result: Int = solveDay05Problem02(input)
        assertNotEquals(19384, result)
        assertNotEquals(19412, result)
        assertEquals(19374, result)
    }
}
