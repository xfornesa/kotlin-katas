package org.fornes.katas.adventofocode.day03

import org.fornes.katas.adventofocode.InputReader
import org.fornes.katas.adventofcode.day03.solveDay03Problem01
import org.fornes.katas.adventofcode.day03.solveDay03Problem02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val measures = InputReader.asListOfStrings("day03/input01-example.txt")

        val result: Int = solveDay03Problem01(measures)
        assertEquals(198, result)
    }

    @Test
    fun testProblem01WithInput() {
        val measures = InputReader.asListOfStrings("day03/input01.txt")

        val result: Int = solveDay03Problem01(measures)
        assertEquals(1092896, result)
    }

    @Test
    fun testProblem02WithExample() {
        val measures = InputReader.asListOfStrings("day03/input02-example.txt")

        val result: Int = solveDay03Problem02(measures)
        assertEquals(230, result)
    }

    @Test
    fun testProblem02WithInput() {
        val measures = InputReader.asListOfStrings("day03/input02.txt")

        val result: Int = solveDay03Problem02(measures)
        assertEquals(4672151, result)
    }
}