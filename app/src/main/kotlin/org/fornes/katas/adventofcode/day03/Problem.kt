package org.fornes.katas.adventofcode.day03

import kotlin.reflect.KFunction2

fun solveDay03Problem01(measures: List<String>): Int {
    val first = measures.first()
    val gamaRate = IntArray(first.length)
    val epsilonRate = IntArray(first.length)

    measures.forEach {
        it.forEachIndexed { i, c ->
            gamaRate[i] += if (c == '1') 1 else -1
            epsilonRate[i] += if (c == '1') -1 else 1
        }
    }
    val gamaRateResult = gamaRate.map(Int::reduceToBinaryChar).joinToString("").binaryToInt()
    val epsilonRateResult = epsilonRate.map(Int::reduceToBinaryChar).joinToString("").binaryToInt()

    return gamaRateResult * epsilonRateResult
}

private fun Int.reduceToBinaryChar() = if (this > 0) '1' else '0'

fun solveDay03Problem02(measures: List<String>): Int {
    val oxygenGeneratorRating = calculateRates(measures, ::calculateDiscriminatorForOxygenIndex)
    val co2ScrubberRating = calculateRates(measures, ::calculateDiscriminatorForCO2Scrubber)

    return oxygenGeneratorRating * co2ScrubberRating
}

private fun calculateRates(
    measures: List<String>,
    calculateDiscriminator: KFunction2<List<String>, Int, Char>
): Int {
    val maxChars = measures.first().length
    var currentMeasures = measures
    var currentIndex = 0
    do {
        val discriminator = calculateDiscriminator(currentMeasures, currentIndex)
        val filteredMeasures = currentMeasures.filter {
            it[currentIndex] == discriminator
        }
        currentMeasures = filteredMeasures
        currentIndex++
    } while (currentIndex < maxChars && currentMeasures.size > 1)

    return currentMeasures.first().binaryToInt()
}

fun calculateDiscriminatorForOxygenIndex(measures: List<String>, currentIndex: Int): Char {
    val sum = measures.map { it[currentIndex] }.map { if (it == '1') 1 else -1 }.sum()
    return if (sum >= 0)
        '1'
    else
        '0'
}

fun calculateDiscriminatorForCO2Scrubber(measures: List<String>, currentIndex: Int): Char {
    val sum = measures.map { it[currentIndex] }.map { if (it == '1') 1 else -1 }.sum()
    return if (sum >= 0)
        '0'
    else
        '1'
}

fun String.binaryToInt() : Int {
    return this.toInt(2)
}
