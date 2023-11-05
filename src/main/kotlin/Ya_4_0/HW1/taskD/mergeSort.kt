package Ya_4_0.HW1.taskD

import java.io.*

fun main() {
    val reader = BufferedReader(FileReader("input.txt"))
    val arrSize = reader.readLine().toInt()
    var arr = intArrayOf()
    if (arrSize != 0) arr = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val out = File("out.txt")
    val outStr = StringBuilder()
    MergeSort.mergeSort(arr).forEach {
        outStr.append(it).append(' ')
    }
    FileOutputStream(out).use { fos ->
        OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
            BufferedWriter(osw).use { bf -> bf.write(outStr.toString()) }
        }
    }
}

object MergeSort {
    fun mergeSort(arr: IntArray): IntArray {
        if (arr.size < 2) return arr
        val arrSize = arr.size
        val separatorPoint: Int = arrSize / 2
        return mergeArr(mergeSort(arr.takeToIndex(separatorPoint - 1)), mergeSort(arr.takeFromIndex(separatorPoint)))
    }

    private fun mergeArr(arr1: IntArray, arr2: IntArray): IntArray {
        val arr1Size = arr1.size
        val arr2Size = arr2.size
        val resArrSize = arr1Size + arr2Size
        val resArr = IntArray(resArrSize)
        var pointerArr1 = 0
        var pointerArr2 = 0
        var pointerResArr = 0
        while (pointerResArr < resArrSize) {
            if (pointerArr1 == arr1Size) {
                while (pointerResArr < resArrSize)
                    resArr[pointerResArr++] = arr2[pointerArr2++]
                break
            }
            if (pointerArr2 == arr2Size) {
                while (pointerResArr < resArrSize)
                    resArr[pointerResArr++] = arr1[pointerArr1++]
                break
            }
            if (arr1[pointerArr1] < arr2[pointerArr2])
                resArr[pointerResArr++] = arr1[pointerArr1++]
            else
                resArr[pointerResArr++] = arr2[pointerArr2++]
        }
        return resArr
    }

    fun IntArray.takeFromIndex(n: Int): IntArray {
        val resArrSize = size - n
        val resArr = IntArray(resArrSize)
        for (index in n until size)
            resArr[index - n] = this[index]
        return resArr
    }

    fun IntArray.takeToIndex(n: Int): IntArray {
        val resArr = IntArray(n + 1)
        for (index in 0..n)
            resArr[index] = this[index]
        return resArr
    }
}


//fun IntArray.takeLastN(n: Int): IntArray {
////        require(n >= 0) { "Requested element count $n is less than zero." }
////        if (n == 0) return intArrayOf()
////        if (n >= size) return this
//    if (n == 1) return intArrayOf(this[size - 1])
//    val arrSize = size
//    val resultArray: IntArray = IntArray(n)
//    val startIndex = arrSize - n
//    for (index in startIndex until arrSize)
//        resultArray[index - startIndex] = this[index]
//    return resultArray
//}
//
//fun IntArray.takeFirstN(n: Int): IntArray {
////        require(n >= 0) { "Requested element count $n is less than zero." }
////        if (n == 0) return intArrayOf()
////        if (n >= size) return this
//    if (n == 1) return intArrayOf(this[0])
//    val resultArray = IntArray(n)
//    for (index in 0 until n)
//        resultArray[index] = this[index]
//    return resultArray
//}