package org.fornes.katas.adventofcode.day04

typealias BingoBoard = Array<IntArray>

fun solveDay04Problem01(bingoGame: Pair<List<Int>, List<BingoBoard>>): Int {
    var (drawnNumbers, boards) = bingoGame
    var winnerBoard = -1
    var drawnIndex = 0
    var drawnNumber = 0

    do {
        drawnNumber = drawnNumbers[drawnIndex]
        boards.forEachIndexed { boardIndex, it ->
            markBoard(it, drawnNumber)
            if (haveLine(it)) {
                winnerBoard = boardIndex
            }
        }
        drawnIndex++
    } while (winnerBoard < 0 && drawnIndex < drawnNumbers.size)

    return drawnNumber * sumUnmarkedNum(boards[winnerBoard])
}

fun sumUnmarkedNum(board: BingoBoard): Int {
    var result = 0
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (board[i][j] != -1) {
                result += board[i][j]
            }
        }
    }
    return result
}

fun haveLine(board: BingoBoard): Boolean {
    var isWinner = false

    // check rows
    for (i in 0 until 5) {
        var doesRowMatch = true
        for (j in 0 until 5) {
            doesRowMatch = doesRowMatch && board[i][j] == -1
        }
        isWinner = isWinner || doesRowMatch
    }

    // check columns
    for (j in 0 until 5) {
        var doesColumnMatch = true
        for (i in 0 until 5) {
            doesColumnMatch = doesColumnMatch && board[i][j] == -1
        }
        isWinner = isWinner || doesColumnMatch
    }

    return isWinner
}

private fun markBoard(it: BingoBoard, drawnNumber: Int) {
    for (i in 0 until 5) {
        for (j in 0 until 5) {
            if (it[i][j] == drawnNumber) {
                it[i][j] = -1
            }
        }
    }
}

fun solveDay04Problem02(bingoGame: Pair<List<Int>, List<BingoBoard>>): Int {
    var (drawnNumbers, boards) = bingoGame
    var drawnIndex = 0
    var drawnNumber = 0
    var lastDrawnNumberWinner = 0
    var lastUnmarkedSum = 0
    var boardWinners = mutableListOf<Int>()

    do {
        drawnNumber = drawnNumbers[drawnIndex]
        boards.forEachIndexed { boardIndex, it ->
            if (boardIndex !in boardWinners) {
                markBoard(it, drawnNumber)
                if (haveLine(it)) {
                    boardWinners.add(boardIndex)
                    lastUnmarkedSum = sumUnmarkedNum(boards[boardIndex])
                    lastDrawnNumberWinner = drawnNumber
                }
            }
        }
        drawnIndex++
    } while (drawnIndex < drawnNumbers.size)

    return lastDrawnNumberWinner * lastUnmarkedSum
}
