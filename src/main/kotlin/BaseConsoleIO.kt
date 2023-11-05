import temp.sumOfTwo
import java.util.*

@Deprecated ("Don't use it, because it's very slow")
private fun scan(){
    val scanner: Scanner = Scanner(System.`in`)
    println(sumOfTwo(scanner.nextInt(),scanner.nextInt()))
}