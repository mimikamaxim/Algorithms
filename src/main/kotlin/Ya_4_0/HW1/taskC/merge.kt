package Ya_4_0.HW1.taskC

import java.io.*
import kotlin.text.StringBuilder

fun main() {
//    val arr1Size = readln().toInt()
//    var arr1 = intArrayOf()
//    if (arr1Size != 0) arr1 = readln().split(" ").map { it.toInt() }.toIntArray() else readln()
//    val arr2Size = readln().toInt()
//    var arr2 = intArrayOf()
//    if (arr2Size != 0) arr2 = readln().split(" ").map { it.toInt() }.toIntArray() else readln()
//    val out = File("out.txt")
//    MergeArr.mergeArr(arr1, arr2).forEach {
////        print("$it ")
//        FileOutputStream(out).use { fos ->
//            OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
//                BufferedWriter(osw).use { bf -> bf.write("$it ") }
//            }
//        }
//    }
//    val start = System.currentTimeMillis()
    val reader = BufferedReader(FileReader("input.txt"))
    val arr1Size = reader.readLine().toInt()
    var arr1 = intArrayOf()
    if (arr1Size != 0) arr1 = reader.readLine().split(" ").map { it.toInt() }.toIntArray() else reader.readLine()
    val arr2Size = reader.readLine().toInt()
    var arr2 = intArrayOf()
    if (arr2Size != 0) arr2 = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
    val out = File("out.txt")
    val outStr = StringBuilder()
    MergeArr.mergeArr(arr1, arr2).forEach {
        outStr.append(it).append(' ')
    }
    FileOutputStream(out).use { fos ->
        OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
            BufferedWriter(osw).use { bf -> bf.write(outStr.toString()) }
        }
    }
//    println(System.currentTimeMillis()-start)
}

object MergeArr {
    fun mergeArr(arr1: IntArray, arr2: IntArray): IntArray {
        val arr1Size = arr1.size
        val arr2Size = arr2.size
        val resArrSize = arr1Size + arr2Size
        val resArr = IntArray(resArrSize)
        var pointerArr1 = 0
        var pointerArr2 = 0
        var pointerResArr = 0
//        while (pointerResArr < resArrSize) {
//            if (pointerArr1 == arr1Size) {
//                while (pointerResArr < resArrSize)
//                    resArr[pointerResArr++] = arr2[pointerArr2++]
//                break
//            }
//            if (pointerArr2 == arr2Size) {
//                while (pointerResArr < resArrSize)
//                    resArr[pointerResArr++] = arr1[pointerArr1++]
//                break
//            }
//            if (arr1[pointerArr1] < arr2[pointerArr2])
//                resArr[pointerResArr++] = arr1[pointerArr1++]
//            else
//                resArr[pointerResArr++] = arr2[pointerArr2++]
//        }
        if (arr1Size > arr2Size) {
            while (pointerArr2 < arr2Size)
                if (arr1[pointerArr1] < arr2[pointerArr2])
                    resArr[pointerResArr++] = arr1[pointerArr1++]
                else
                    resArr[pointerResArr++] = arr2[pointerArr2++]
            while (pointerResArr < resArrSize)
                resArr[pointerResArr++] = arr1[pointerArr1++]
        } else
            if (arr1Size < arr2Size) {
                while (pointerArr1 < arr1Size)
                    if (arr1[pointerArr1] < arr2[pointerArr2])
                        resArr[pointerResArr++] = arr1[pointerArr1++]
                    else
                        resArr[pointerResArr++] = arr2[pointerArr2++]
                while (pointerResArr < resArrSize)
                    resArr[pointerResArr++] = arr2[pointerArr2++]
            } else {
                while (pointerArr1<arr1Size && pointerArr2<arr2Size)
                    if (arr1[pointerArr1] < arr2[pointerArr2])
                        resArr[pointerResArr++] = arr1[pointerArr1++]
                    else
                        resArr[pointerResArr++] = arr2[pointerArr2++]
                if (pointerArr1==arr1Size)
                    while (pointerResArr < resArrSize)
                        resArr[pointerResArr++] = arr2[pointerArr2++]
                else
                    while (pointerResArr < resArrSize)
                        resArr[pointerResArr++] = arr1[pointerArr1++]
            }
        return resArr
    }
}