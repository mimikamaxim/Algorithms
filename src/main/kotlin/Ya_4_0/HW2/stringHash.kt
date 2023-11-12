package Ya_4_0.HW2

import java.io.*

const val x_ = 257
const val p = 1_000_000_007

fun main() {
    val reader = BufferedReader(FileReader("input.txt"))
    var s = reader.readLine()
    val requestSize = reader.readLine().toInt()
    //test str
//    var s = "some str some"
    val n = s.length
    val h = LongArray(n + 1)
    val x = LongArray(n + 1)
    x[0] = 1
    s = " $s"
    for (i in 1..n) {
        h[i] = (h[i - 1] * x_ + s[i].code) % p
        x[i] = (x[i - 1] * x_) % p
    }
    fun isEqual(from1:Int,from2:Int, slen:Int): Boolean{
        return (h[from1+slen-1]+h[from2-1]*x[slen]) % p ==
                (h[from2+slen-1]+h[from1-1]*x[slen]) % p
    }

    //test out
//    println(isEqual(2,10,4))
    var currentRequest= IntArray(3)
    val outBuffer = StringBuilder()
    for (i in 1..requestSize) {
        currentRequest = reader.readLine().split(" ").map { it.toInt() }.toIntArray()
        if (isEqual(
                currentRequest[1] + 1,
                currentRequest[2] + 1,
                currentRequest[0]
            )
        ) outBuffer.append("yes\n") else outBuffer.append("no\n")
    }
    val out = File("output.txt")
    FileOutputStream(out).use { fos ->
        OutputStreamWriter(fos, Charsets.UTF_8).use { osw ->
            BufferedWriter(osw).use { bf -> bf.write(outBuffer.toString()) }
        }
    }
}