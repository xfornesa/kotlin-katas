package org.fornes.katas.adventofocode.day04

import org.fornes.katas.adventofcode.day04.solveDay04Problem01
import org.fornes.katas.adventofcode.day04.solveDay04Problem02
import org.fornes.katas.adventofocode.InputReader
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class ProblemTest {

    @Test
    fun testProblem01WithExample() {
        val bingoGame = InputReader.asBingoGame("day04/input01-example.txt")

        val result: Int = solveDay04Problem01(bingoGame)
        assertEquals(4512, result)
    }

    @Test
    fun testProblem01WithInput() {
        val bingoGame = InputReader.asBingoGame("day04/input01.txt")

        val result: Int = solveDay04Problem01(bingoGame)
        assertEquals(14093, result)
    }

    @Test
    fun testProblem02WithExample() {
        val bingoGame = InputReader.asBingoGame("day04/input02-example.txt")

        val result: Int = solveDay04Problem02(bingoGame)
        assertEquals(1924, result)
    }

    @Test
    fun testProblem02WithInput() {
        val bingoGame = InputReader.asBingoGame("day04/input02.txt")

        val result: Int = solveDay04Problem02(bingoGame)
        assertEquals(17388, result)
    }
}