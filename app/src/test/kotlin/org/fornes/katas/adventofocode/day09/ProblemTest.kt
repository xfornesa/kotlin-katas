package org.fornes.katas.adventofocode.day09

import org.fornes.katas.adventofcode.day09.solveDay09Problem01
import org.fornes.katas.adventofcode.day09.solveDay09Problem02
import org.fornes.katas.adventofocode.InputReader
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val input = InputReader.asIntMatrix("day09/input01-example.txt")

        val result: Int = solveDay09Problem01(input)
        assertEquals(15, result)
    }

    @Test
    fun testProblem01WithInput() {
        val input = InputReader.asIntMatrix("day09/input01.txt")

        val result: Int = solveDay09Problem01(input)
        assertEquals(436, result)
    }

    @Test
    fun testProblem02WithExample() {
        val input = InputReader.asIntMatrix("day09/input02-example.txt")

        val result: Int = solveDay09Problem02(input)
        assertEquals(1134, result)
    }

    @Test
    fun testProblem02WithInput() {
        val input = InputReader.asIntMatrix("day09/input02.txt")

        val result: Int = solveDay09Problem02(input)
        assertNotEquals(996170, result)
        assertNotEquals(817908, result)
        assertEquals(1317792, result)
    }
}
