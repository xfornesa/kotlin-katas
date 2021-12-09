package org.fornes.katas.adventofocode

import java.io.File

typealias BingoBoard = Array<IntArray>

typealias Coordinate = Pair<Int, Int>

typealias Vector = Pair<Coordinate, Coordinate>

class InputReader {

    companion object {
        fun asListOfInts(fileName: String): List<Int> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .flatMap { it.split(",") }
                .map { it.trim() }
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

        fun asListOfPairsOfListString(fileName: String): List<Pair<List<String>, List<String>>> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map {
                    val split = it.split(" | ")
                    Pair(split[0].split(" "), split[1].split(" "))
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

        fun asListOfVectors(fileName: String): List<Vector> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map {
                    val vectorPart = it.split(" -> ")
                    val coordsLeft = vectorPart[0].split(",")
                    val coordsRight = vectorPart[1].split(",")
                    Pair(Pair(coordsLeft[0].toInt(), coordsLeft[1].toInt()), Pair(coordsRight[0].toInt(), coordsRight[1].toInt()))
                }
        }

        fun asIntMatrix(fileName: String): Array<IntArray> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map {
                    it.toCharArray()
                }
                .map {
                    it.map { it.toString().toInt() }
                }
                .map {
                    it.toIntArray()
                }
                .toTypedArray()

        }
    }
}
