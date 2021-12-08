package org.fornes.katas.adventofcode.day08

val mappingNumberToSegments = mapOf(
    1 to 2, // reference
    4 to 4, // reference
    7 to 3, // reference
    8 to 7, // reference
    9 to 6, // shares segments 4
    0 to 6, // shares segments with 8
    6 to 6, // ¿? <- remaining one with 6 segments
    5 to 5, // shares segments with 6
    3 to 5, // shares segments with 8 and 1
    2 to 5, // ¿? <- remaining one with 5 segments
)

fun solveDay08Problem01(input: List<Pair<List<String>, List<String>>>): Int {
    val occurrences = intArrayOf(0, 0, 0, 0, 0, 0, 0, 0)
    input.map { it.second }.forEach {
        val eachCount: Map<Int, Int> = it.map { it.length }.groupingBy { it }.eachCount()
        eachCount.forEach { occurrence ->
            occurrences[occurrence.key] += occurrence.value
        }
    }
    return occurrences[mappingNumberToSegments[1]!!] + occurrences[mappingNumberToSegments[4]!!] + occurrences[mappingNumberToSegments[7]!!] + occurrences[mappingNumberToSegments[8]!!]
}

fun solveDay08Problem02(input: List<Pair<List<String>, List<String>>>): Int {

    return input.map {
        val mappings = decode(it.first)
        val signalMappings = mappings.map{(k,v) -> v to k}.toMap()
        Pair(signalMappings, it.second)
    }.map { pairs ->
        val signalMappings = pairs.first
        val signalOutputs = pairs.second
        signalOutputs.map { signal -> signalMappings[signal.sorted()].toString() }.joinToString("").toInt()
    }.sum()
}

fun decode(signalPatterns: List<String>): Map<Int, String> {
    var result: MutableMap<Int, String> = mutableMapOf()
    /*
    Strategy:
    * decode 1, 4, 7, 8
    * decode 9
    * decode 0
    * decode 6
    * decode 5
    * decode 3
    * decode 2
     */
    // Decode 1
    result[1] = signalPatterns.filter { it.length == mappingNumberToSegments[1] }.first().sorted()

    // Decode 4
    result[4] = signalPatterns.filter { it.length == mappingNumberToSegments[4] }.first().sorted()

    // Decode 7
    result[7] = signalPatterns.filter { it.length == mappingNumberToSegments[7] }.first().sorted()

    // Decode 8
    result[8] = signalPatterns.filter { it.length == mappingNumberToSegments[8] }.first().sorted()

    // Decode 9
    result[9] = signalPatterns.filter { it.length == mappingNumberToSegments[9] }.filter {
        it.toSet().containsAll(result[4]!!.toSet())
                && it.toSet().containsAll(result[1]!!.toSet())
    }.first().sorted()

    // Decode 0
    result[0] = signalPatterns.filter { it.length == mappingNumberToSegments[0] }.filter {
        result[8]!!.toSet().containsAll(it.toSet())
                && it.toSet().containsAll(result[1]!!.toSet())
                && it.sorted() != result[9]
    }.first().sorted()

    // Decode 6
    result[6] = signalPatterns.filter { it.length == mappingNumberToSegments[6] }.filter {
        it.sorted() != result[0]
                && it.sorted() != result[9]
                && !it.toSet().containsAll(result[1]!!.toSet())
    }.first().sorted()

    // Decode 5
    result[5] = signalPatterns.filter { it.length == mappingNumberToSegments[5] }.filter {
        result[6]!!.toSet().containsAll(it.toSet())
    }.first().sorted()

    // Decode 3
    result[3] = signalPatterns.filter { it.length == mappingNumberToSegments[3] }.filter {
        result[8]!!.toSet().containsAll(it.toSet())
                && it.toSet().containsAll(result[1]!!.toSet())
    }.first().sorted()

    // Decode 2
    result[2] = signalPatterns.filter { it.length == mappingNumberToSegments[2] }.filter {
        it.sorted() != result[3]
                && it.sorted() != result[5]
    }.first().sorted()

    return result
}

private fun String.sorted() = this.toCharArray().sorted().joinToString("")
