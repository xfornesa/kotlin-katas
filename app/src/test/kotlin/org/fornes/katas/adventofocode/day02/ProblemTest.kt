package org.fornes.katas.adventofocode.day02

import org.fornes.katas.adventofocode.InputReader
import org.fornes.katas.adventofcode.day02.solveDay02Problem01
import org.fornes.katas.adventofcode.day02.solveDay02Problem02
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val measures = InputReader.asListOfPairsStringInt("day02/input01-example.txt")

        val result: Int = solveDay02Problem01(measures)
        assertEquals(150, result)
    }

    @Test
    fun testProblem01WithInput() {
        val measures = InputReader.asListOfPairsStringInt("day02/input01.txt")

        val result: Int = solveDay02Problem01(measures)
        assertEquals(2039256, result)
    }

    @Test
    fun testProblem02WithExample() {
        val measures = InputReader.asListOfPairsStringInt("day02/input02-example.txt")

        val result: Int = solveDay02Problem02(measures)
        assertEquals(900, result)
    }

    @Test
    fun testProblem02WithInput() {
        val measures = InputReader.asListOfPairsStringInt("day02/input02.txt")

        val result: Int = solveDay02Problem02(measures)
        assertEquals(1856459736, result)
    }
}