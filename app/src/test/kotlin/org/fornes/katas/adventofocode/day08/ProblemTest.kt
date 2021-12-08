package org.fornes.katas.adventofocode.day08

import org.fornes.katas.adventofocode.InputReader
import org.fornes.katas.adventofcode.day08.solveDay08Problem01
import org.fornes.katas.adventofcode.day08.solveDay08Problem02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val input = InputReader.asListOfPairsOfListString("day08/input01-example.txt")

        val result: Int = solveDay08Problem01(input)
        assertEquals(26, result)
    }

    @Test
    fun testProblem01WithInput() {
        val input = InputReader.asListOfPairsOfListString("day08/input01.txt")

        val result: Int = solveDay08Problem01(input)
        assertEquals(387, result)
    }

    @Test
    fun testProblem02WithExample() {
        val input = InputReader.asListOfPairsOfListString("day08/input02-example.txt")

        val result: Int = solveDay08Problem02(input)
        assertEquals(61229, result)
    }

    @Test
    fun testProblem02WithInput() {
        val input = InputReader.asListOfPairsOfListString("day08/input02.txt")

        val result: Int = solveDay08Problem02(input)
        assertEquals(986034, result)
    }
}