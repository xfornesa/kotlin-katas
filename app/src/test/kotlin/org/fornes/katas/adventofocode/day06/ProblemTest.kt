package org.fornes.katas.adventofocode.day06

import org.fornes.katas.adventofcode.day06.solveDay06Problem01
import org.fornes.katas.adventofcode.day06.solveDay06Problem02
import org.fornes.katas.adventofocode.InputReader
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val input = InputReader.asListOfInts("day06/input01-example.txt")

        val result: Long = solveDay06Problem01(input)
        assertEquals(5934, result)
    }

    @Test
    fun testProblem01WithInput() {
        val input = InputReader.asListOfInts("day06/input01.txt")

        val result: Long = solveDay06Problem01(input)
        assertEquals(395627, result)
    }

    @Test
    fun testProblem02WithExample() {
        val input = InputReader.asListOfInts("day06/input02-example.txt")

        val result: Long = solveDay06Problem02(input)
        assertEquals(26984457539, result)
    }

    @Test
    fun testProblem02WithInput() {
        val input = InputReader.asListOfInts("day06/input02.txt")

        val result: Long = solveDay06Problem02(input)
        assertEquals(1767323539209, result)
    }
}