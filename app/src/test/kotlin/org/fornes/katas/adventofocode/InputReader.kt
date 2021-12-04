package org.fornes.katas.adventofocode

import java.io.File

typealias BingoBoard = Array<IntArray>

class InputReader {

    companion object {
        fun asListOfInts(fileName: String): List<Int> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map { it.toInt() }
        }

        fun asListOfStrings(fileName: String): List<String> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
        }

        fun asListOfPairsStringInt(fileName: String): List<Pair<String, Int>> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map {
                    val split = it.split(" ")
                    Pair(split[0], split[1].toInt())
                }
        }

        fun asBingoGame(fileName: String): Pair<List<Int>, List<BingoBoard>> {
            val boards = mutableListOf<BingoBoard>()
            val lines = File("src/test/resources/adventofcode/${fileName}").readLines()
            val drawnNumbers = lines.first().split(",").map { it.toInt() }
            var currentBoard = Array(5) { IntArray(5) }
            var currentBoardRow = 0
            for (line in lines.drop(2)) {
                if (line.isEmpty()) {
                    boards.add(currentBoard.clone())
                    currentBoard = Array(5) { kotlin.IntArray(5) }
                    currentBoardRow = 0
                    continue
                }
                currentBoard[currentBoardRow] = line.trim().split(Regex("\\s+")).map { it.toInt() }.toIntArray()
                currentBoardRow++
            }

            return Pair(drawnNumbers, boards)
        }
    }
}