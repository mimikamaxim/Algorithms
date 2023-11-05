package Ya_4_0.HW1.taskE

import java.io.*

fun main() {
    val reader = BufferedReader(FileReader("input.txt"))
    val arrSize = reader.readLine().toInt()
    val arr = mutableListOf<String>()
    for (i in 0 until arrSize)
        arr.add(reader.readLine())
    CounterSort.counterSort(arr)
    val out = File("output.txt")
    FileOutputStream(out).use { fos ->
        OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
            BufferedWriter(osw).use { bf -> bf.write(CounterSort.strBuilder.toString()) }
        }
    }
}

object CounterSort {
    val strBuilder = StringBuilder()
    fun counterSort(inputArr: List<String>): List<String> {
        strBuilder.append("Initial array:\n")
        inputArr.forEachIndexed { index, s ->  strBuilder.append(s); if (index!=inputArr.lastIndex) strBuilder.append(", ") }
        strBuilder.append("\n**********\n")
        var arr = inputArr.toMutableList()
        val signs = arr[0].length
        var bucket0: MutableList<String>
        var bucket1: MutableList<String>
        var bucket2: MutableList<String>
        var bucket3: MutableList<String>
        var bucket4: MutableList<String>
        var bucket5: MutableList<String>
        var bucket6: MutableList<String>
        var bucket7: MutableList<String>
        var bucket8: MutableList<String>
        var bucket9: MutableList<String>
        for (i in signs - 1 downTo 0) {
            strBuilder.append("Phase ").append(signs-i).append("\n")
            bucket0 = mutableListOf()
            bucket1 = mutableListOf()
            bucket2 = mutableListOf()
            bucket3 = mutableListOf()
            bucket4 = mutableListOf()
            bucket5 = mutableListOf()
            bucket6 = mutableListOf()
            bucket7 = mutableListOf()
            bucket8 = mutableListOf()
            bucket9 = mutableListOf()
            arr.forEach {
                when (it[i].digitToInt()) {
                    0 -> bucket0.add(it)
                    1 -> bucket1.add(it)
                    2 -> bucket2.add(it)
                    3 -> bucket3.add(it)
                    4 -> bucket4.add(it)
                    5 -> bucket5.add(it)
                    6 -> bucket6.add(it)
                    7 -> bucket7.add(it)
                    8 -> bucket8.add(it)
                    9 -> bucket9.add(it)
                    else -> throw IllegalArgumentException("Not a number!!")
                }
            }
            arr = mutableListOf()
            strBuilder.append("Bucket 0: ")
            if (bucket0.isNotEmpty()) bucket0.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket0.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 1: ")
            if (bucket1.isNotEmpty()) bucket1.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket1.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 2: ")
            if (bucket2.isNotEmpty()) bucket2.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket2.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 3: ")
            if (bucket3.isNotEmpty()) bucket3.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket3.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 4: ")
            if (bucket4.isNotEmpty()) bucket4.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket4.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 5: ")
            if (bucket5.isNotEmpty()) bucket5.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket5.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 6: ")
            if (bucket6.isNotEmpty()) bucket6.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket6.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 7: ")
            if (bucket7.isNotEmpty()) bucket7.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket7.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 8: ")
            if (bucket8.isNotEmpty()) bucket8.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket8.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\nBucket 9: ")
            if (bucket9.isNotEmpty()) bucket9.forEachIndexed {index,it -> arr.add(it); strBuilder.append(it); if(index!=bucket9.lastIndex) strBuilder.append(", ") }
            else strBuilder.append("empty")
            strBuilder.append("\n**********\n")
        }
        strBuilder.append("Sorted array:\n")
        arr.forEachIndexed { i,it -> strBuilder.append(it); if (i!=arr.lastIndex) strBuilder.append(", ") }
        return arr
    }
}