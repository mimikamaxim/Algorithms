package Ya_4_0.HW1

import java.io.*

fun main() {
//    val arrSize = readln().toInt()
//    var arr = intArrayOf()
//    if (arrSize!=0) arr = readln().split(" ").map { it.toInt() }.toIntArray() else readln()
//    val pivot = readln().toInt()
//    val result = TaskA_partition_clean.partition(arr,pivot,0, arr.size)
//    println(result.first)
//    println(arr.size-result.first)
    val reader = BufferedReader(FileReader("input.txt"))
    val arrSize = reader.readLine().toInt()
    var arr = intArrayOf()
    if (arrSize != 0) arr = reader.readLine().split(" ").map { it.toInt() }.toIntArray() else reader.readLine()
    val pivot = reader.readLine().toInt()
    val result = TaskA_partition_clean.partition(arr,pivot,0, arr.size)
    val resStr = "${result.first}\n${(arr.size-result.first)}"
    val out = File("output.txt")
    FileOutputStream(out).use { fos ->
        OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
            BufferedWriter(osw).use { bf -> bf.write(resStr) }
        }
    }
}

internal object TaskA_partition_clean {
    fun partition2(arr: IntArray, pivot: Int): Int {
        val pair = arr.partition { it < pivot }
        return pair.first.size;
    }

    /**
     * @return <code>Pair()</code> first - is Equal index, second - is Grater index (can be out of bounds)
     */
    fun partition(arr: IntArray, pivot: Int, fromI: Int, toI: Int): Pair<Int, Int> {
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