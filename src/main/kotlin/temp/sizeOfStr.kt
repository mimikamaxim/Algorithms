package temp

import java.util.*

fun  main() {
    val scanner = Scanner(System.`in`)
    val mapOfLength = mutableMapOf <Int,Int>()
    while (scanner.hasNext()){
        val str = scanner.nextLine()
        if (mapOfLength.containsKey(str.length)) {
            var curr = mapOfLength[str.length]!!
            curr++
            mapOfLength[str.length] = curr
        }
        else
            mapOfLength.put(str.length, 1)
    }
    mapOfLength.forEach {
        println(it)
    }
}

// Lima WIS

