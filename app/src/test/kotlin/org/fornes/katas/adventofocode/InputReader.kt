package org.fornes.katas.adventofocode

import java.io.File

class InputReader {

    companion object {
        fun asListOfInts(fileName: String): List<Int> {
            return File("src/test/resources/adventofcode/${fileName}")
                .useLines { it.toList() }
                .map { it.toInt() }
        }
    }
}