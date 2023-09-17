package temp

import java.util.Scanner

fun main () {
    val scanner: Scanner = Scanner(System.`in`)
    println(sumOfTwo(scanner.nextInt(),scanner.nextInt()))
}
fun sumOfTwo(a: Int, b: Int): Int {
    return a + b
}