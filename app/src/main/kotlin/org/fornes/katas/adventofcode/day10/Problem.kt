package org.fornes.katas.adventofcode.day10

val closingChar = mapOf(
    '(' to ')',
    '[' to ']',
    '{' to '}',
    '<' to '>',
)

fun solveDay10Problem01(input: List<String>): Long {
    val occ = mutableMapOf(
        ')' to 0,
        ']' to 0,
        '}' to 0,
        '>' to 0,
    )

    input.forEach outer@{ line ->
        val chars = line.toCharArray()
        val stack = arrayDequeOf<Char>()
        chars.forEach { char ->
            when (char) {
                '(', '[', '{', '<' -> {
                    stack.push(closingChar[char]!!)
                }
                ')', ']', '}', '>' -> {
                    val pop: Char? = stack.pop()
                    if (char != pop) {
                        occ[char] = occ[char]?.plus(1) ?: 1
                        return@outer
                    }
                }
            }
        }

    }

    val scores = mutableMapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137,
    )

    return occ.map { scores[it.key]!! * it.value.toLong() }.sum()
}

fun solveDay10Problem02(input: List<String>): Long {
    val scores = mutableMapOf(
        ')' to 1,
        ']' to 2,
        '}' to 3,
        '>' to 4,
    )


    val results = mutableListOf<Long>()
    input.forEach outer@{ line ->
        val chars = line.toCharArray()
        val stack = arrayDequeOf<Char>()
        var score: Long = 0
        chars.forEach { char ->
            when (char) {
                '(', '[', '{', '<' -> {
                    stack.push(closingChar[char]!!)
                }
                ')', ']', '}', '>' -> {
                    val pop: Char? = stack.pop()
                    if (char != pop) {
                        return@outer
                    }
                }
            }
        }
        val missing = stack.reversed()
        missing.forEach { char ->
            score = score * 5 + scores[char]!!
        }
        results.add(score)
    }

    return results.sorted()[(results.size / 2)]
}

fun <T> arrayDequeOf() = ArrayDeque<T>(mutableListOf())

fun <T> arrayDequeOf(vararg elements: T) = ArrayDeque(elements.toList())

fun <T> ArrayDeque<T>.push(element: T) = addLast(element) // returns Unit

fun <T> ArrayDeque<T>.pop() = removeLastOrNull()          // returns T?
