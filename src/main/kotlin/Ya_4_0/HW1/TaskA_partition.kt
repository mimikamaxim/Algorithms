package Ya_4_0.HW1

import java.util.*

object ooo {
    val arrFinal = arrayOf(1, 2)
    val arrfinal2 = listOf<Int>(1, 2)
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
    println()
    //5
    //1 9 4 2 3
    //3
    val scanner: Scanner = Scanner(System.`in`)
    val arrSize = scanner.nextInt();
    val arr = IntArray(arrSize)
    for (i in 0 until arrSize)
        arr[i] = scanner.nextInt()
    val pivot = scanner.nextInt()
    val point = partition(arr,pivot)
    println(pivot-1)
    println(arr.size-pivot+1)
}

fun arrChange(arr: IntArray) {
    arr[0] = -1;
}

//принимает на вход предикат и пару итераторов, задающих массив (или массив и два индекса в нём),
// а возвращает точку разбиения, то есть итератор (индекс) на конец части, которая содержащит элементы,
// удовлетворяющие заданному предикату.

//todo corner cases

fun partition(arr: IntArray, pivot: Int): Int {
    val arrLength = arr.size
    var equalsPoint = 0
    var greaterPoint = 0
    var nextPoint = 0
    while (nextPoint < arrLength) {
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
    return equalsPoint
}

fun intCompare(pivot: Int, current: Int): Int {
    if (pivot < current) return 1
    return if (pivot > current) -1 else 0
}