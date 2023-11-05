package Ya_4_0.HW1

import java.io.*
import kotlin.random.Random

fun main() {
//    val arrSize = readln().toInt()
//    var arr = intArrayOf()
//    if (arrSize!=0) arr = readln().split(" ").map { it.toInt() }.toIntArray() else return
//    TaskB_qSort.qSort(arr,0,arr.size)
//    arr.forEach { print("$it ") }
    val reader = BufferedReader(FileReader("input.txt"))
    val arrSize = reader.readLine().toInt()
    var arr = intArrayOf()
    if (arrSize != 0) arr = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val out = File("output.txt")
    val outStr = StringBuilder()
    TaskB_qSort.qSort(arr, 0, arr.size)
    arr.forEach {
        outStr.append(it).append(' ')
    }
    FileOutputStream(out).use { fos ->
        OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
            BufferedWriter(osw).use { bf -> bf.write(outStr.toString()) }
        }
    }
}

internal object TaskB_qSort {

    val randomProvider = Random(1)

    fun qSort(arr: IntArray, start: Int, end: Int) { //inplace
        if (end - start < 2) return
        val pair = partition(arr, arr[randomProvider.nextInt(start, end - 1)], start, end)
        if (start != pair.first) qSort(arr, start, pair.first)
        if (end != pair.second) qSort(arr, pair.second, end)
    }

    private fun partition(arr: IntArray, pivot: Int, fromI: Int, toI: Int): Pair<Int, Int> {
        var equalsPoint = fromI
        var greaterPoint = fromI
        var nextPoint = fromI
        while (nextPoint < toI) {
            when (intCompare(pivot, arr[nextPoint])) {
                1 -> {
                    nextPoint++
                }

                -1 -> {
                    val acc = arr[nextPoint]
                    arr[nextPoint] = arr[greaterPoint]
                    arr[greaterPoint] = arr[equalsPoint]
                    arr[equalsPoint] = acc
                    equalsPoint++
                    greaterPoint++
                    nextPoint++
                }

                0 -> {
                    val acc = arr[nextPoint]
                    arr[nextPoint] = arr[greaterPoint]
                    arr[greaterPoint] = acc
                    greaterPoint++
                    nextPoint++
                }
            }
        }
        return Pair(equalsPoint, greaterPoint)
    }

    private fun intCompare(pivot: Int, current: Int): Int {
        if (pivot < current) return 1
        return if (pivot > current) -1 else 0
    }
}