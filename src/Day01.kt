fun main() {
    fun part1(input: List<String>): Int {
        var mostCalories = 0
        input.map { it.toIntOrNull() }.fold(0) {
            acc, el ->
            if (el == null) {
                if (mostCalories < acc) {
                    mostCalories = acc
                }
                0
            } else {
                acc+el
            }
        }
        return mostCalories
    }

    fun part2(input: List<String>): Int {
        val calories = mutableListOf<Int>()
        input.map { it.toIntOrNull() }
            .fold(0) { acc, el ->
                if(el == null) {
                    calories.add(acc)
                    0
                }
                else acc+el
            }
        return calories.sortedDescending().take(3).sum()
    }

    // test if implementation meets criteria from the description, like:
    // val testInput = readInput("Day01_test")
    // check(part1(testInput) == 1)

    val input = readInput("Day01")
    println(part1(input))
    println(part2(input))
}