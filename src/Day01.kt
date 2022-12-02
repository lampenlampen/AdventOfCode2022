import kotlin.time.ExperimentalTime

@OptIn(ExperimentalTime::class)
fun main() {
	fun parseInput(input: String): List<Int> = input
		.split("\n\n")
		.map { elv -> elv.lines().sumOf { it.toInt() } }

	fun topNElves(elves: List<Int>, n: Int): Int {
		fun findTopN(n: Int, element: List<Int>): List<Int> {
			if (element.size == n) return element

			val small = mutableListOf<Int>()
			val equal = mutableListOf<Int>()
			val big = mutableListOf<Int>()

			val x = element.random()
			element.forEach {
				if (it < x) small.add(it)
				if (it == x) equal.add(it)
				if (it > x) big.add(it)
			}

			if (big.size >= n) return findTopN(n, big)
			if (equal.size + big.size >= n) return (equal + big).takeLast(n)
			return findTopN(n - equal.size - big.size, small) + equal + big
		}

		return findTopN(n, elves).sum()
	}

	fun part1(input: String): Int = topNElves(parseInput(input), 1)
	fun part2(input: String): Int = topNElves(parseInput(input), 3)

	// test if implementation meets criteria from the description, like:
	// val testInput = readInputByLines("Day01_test")
	// check(part1(testInput) == 1)

	val input = readInput("Day01")

	println(part1(input))
	println(part2(input))
}