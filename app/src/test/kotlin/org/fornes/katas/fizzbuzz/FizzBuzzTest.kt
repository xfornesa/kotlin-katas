package org.fornes.katas.fizzbuzz

import org.junit.jupiter.api.Test

class FizzBuzzTest {

    @Test
    fun whenUsingForWithIfs() {
        for (i in 1..100) {
            if ((i % 3 == 0) && (i % 5 == 0)) {
                println("FizzBuzz")
            } else if (i % 3 == 0) {
                println("Fizz")
            } else if (i % 5 == 0) {
                println("Buzz")
            } else {
                println(i)
            }
        }
    }

    @Test
    fun whenUsingForWithWhen() {
        for (i in 1..100) {
            when {
                (i % 3 == 0) && (i % 5 == 0) -> println("FizzBuzz")
                i % 3 == 0 -> println("Fizz")
                i % 5 == 0 -> println("Buzz")
                else -> println(i)
            }
        }
    }

    @Test
    fun whenRepeatWithWhen() {
        repeat(100) {
            when {
                (it % 3 == 0) && (it % 5 == 0) -> println("FizzBuzz")
                it % 3 == 0 -> println("Fizz")
                it % 5 == 0 -> println("Buzz")
                else -> println(it)
            }
        }
    }

    @Test
    fun whenRepeatWithFunction() {
        fun printFizzBuzz(it: Int) {
            when {
                (it % 3 == 0) && (it % 5 == 0) -> println("FizzBuzz")
                it % 3 == 0 -> println("Fizz")
                it % 5 == 0 -> println("Buzz")
                else -> println(it)
            }
        }

        repeat(100) {
            printFizzBuzz(it)
        }
    }

    @Test
    internal fun whenRangeWithStream() {
        fun toFizzBuzz(number: Int): String {
            return when {
                (number % 3 == 0) && (number % 5 == 0) -> "FizzBuzz"
                number % 3 == 0 -> "Fizz"
                number % 5 == 0 -> "Buzz"
                else -> number.toString()
            }
        }

        (1..100).map(::toFizzBuzz).forEach(::println)
    }

    @Test
    internal fun whenFunctionExtension() {
        fun Int.toFizzBuzz(): String {
            return when {
                (this % 3 == 0) && (this % 5 == 0) -> "FizzBuzz"
                this % 3 == 0 -> "Fizz"
                this % 5 == 0 -> "Buzz"
                else -> this.toString()
            }
        }

        (1..100).map(Int::toFizzBuzz).forEach(::println)
    }
}
