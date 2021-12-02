package org.fornes.katas.adventofocode

import java.io.File

class InputReader {

    companion object {
        fun asListOfInts(fileName: String): List<Int> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map { it.toInt() }
        }

        fun asListOfPairsStringInt(fileName: String): List<Pair<String, Int>> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map {
                    val split = it.split(" ")
                    Pair(split[0], split[1].toInt())
                }
        }
    }
}