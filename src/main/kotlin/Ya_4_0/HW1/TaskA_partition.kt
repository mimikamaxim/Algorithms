package Ya_4_0.HW1

import java.util.*
import java.util.concurrent.atomic.AtomicBoolean
import java.util.concurrent.atomic.AtomicInteger
import kotlin.random.Random

object ooo {
    val arrFinal = arrayOf(1, 2)
    val arrfinal2 = listOf<Int>(1, 2)
    val randomGenerator = Random(1)
    var counterN = 0;
}

fun main() {
//    val arr: IntArray = intArrayOf(1, 7, 3, 5);
//    println(arr.contentToString())
//    arrChange(arr)
//    println(arr.contentToString())
//    val arr2 = IntArray(1000_000) //base arr int primitive inside
//    val arr3 = arrayOf(1, 2) //base arr Integer class inside
//    val arr4 = listOf<Int>(1, 2) //class arr Integer class inside
//    ooo.arrfinal2
//    val smt = ooo.arrfinal2
//    println(smt);
//    println()
    //5
    //1 9 4 2 3
    //3
//    val scanner: Scanner = Scanner(System.`in`)
//    val arrSize = scanner.nextInt();
//    val arr = IntArray(arrSize)
//    for (i in 0 until arrSize)
//        arr[i] = scanner.nextInt()
//    val pivot = scanner.nextInt()
//    val point = partition(arr, pivot, 0, arrSize - 1)
//    println(arr.contentToString())
//    println(arr.size - point.first)
//    println(point.first)

    val test = intArrayOf(1, 2, 8, 2, 3)
    val time = System.currentTimeMillis()
//    val test = intArrayOf(1,1,1,1,1,1,1,1,1,-1)
    println(test.contentToString())
    qSort(test, 0, test.size)
    println(test.contentToString())
    println(System.currentTimeMillis()-time)
}

fun arrChange(arr: IntArray) {
    arr[0] = -1;
}

//принимает на вход предикат и пару итераторов, задающих массив (или массив и два индекса в нём),
// а возвращает точку разбиения, то есть итератор (индекс) на конец части, которая содержащит элементы,
// удовлетворяющие заданному предикату.

//todo corner cases
// также потестить скорость стандартной функции IntArray.partition

fun qSort(arr: IntArray, start: Int, end: Int) { //inplace
    if (end-start<2) return
    val pair = partition(arr, arr[ooo.randomGenerator.nextInt(start, end)], start, end)
    if (start != pair.first) qSort(arr, start, pair.first)
    if (end != pair.second) qSort(arr, pair.second, end)
}

fun partition(arr: IntArray, pivot: Int, fromI: Int, toI: Int): Pair<Int, Int> {
//    if (arr.isEmpty()) return 0
//    if (arr.size==1) return if (arr[0]<pivot) 1 else 0
//    val arrLength = arr.size
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