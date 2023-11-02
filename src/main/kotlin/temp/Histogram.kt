package temp


import java.util.*

fun  main() {
    val scanner = Scanner(System.`in`)
    val mapOfLength = mutableMapOf <Int,Int>()
    while (scanner.hasNext()){
        val str = scanner.nextLine()
        str.split(" ").forEach{it ->
            if (mapOfLength.containsKey(it.length)) {
                var curr = mapOfLength[it.length]!!
                curr++
                mapOfLength[it.length] = curr
            }
            else
                mapOfLength.put(it.length, 1)
        }
    }

//    val max_value = mapOfLength.keys.max()
//    for (i in 1..max_value){
//        println("{max}")
//    }
//    mapOfLength.forEach {
//        println(it)
//    }
}