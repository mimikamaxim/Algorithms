package temp

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import java.io.ByteArrayInputStream
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*

internal class SummOfTwoKtTest {

    @Test
    fun sumOfTwo() {
        assertEquals(temp.sumOfTwo(1, 2), 3)
        assertEquals(temp.sumOfTwo(0, 2), 2)
        assertEquals(temp.sumOfTwo(-1, 2), 1)
        assertEquals(temp.sumOfTwo(1, -2), -1)
        assertEquals(temp.sumOfTwo(3, 2), 5)
    }

    //    @TestInstance(TestInstance.Lifecycle.PER_METHOD)
    internal class StdInOutTestKotlin {
        private val systemIn = System.`in`
        private val systemOut = System.out
        private var testIn: ByteArrayInputStream? = null
        private var testOut: ByteArrayOutputStream? = null

        @BeforeEach
        fun setUpOutput() {
//            System.out.println("Before called^");
            testOut = ByteArrayOutputStream()
            System.setOut(PrintStream(testOut))
        }

        private fun provideInput(data: String) {
            testIn = ByteArrayInputStream(data.toByteArray())
            System.setIn(testIn)
        }

        private val output: String
            get() = testOut.toString()

        @AfterEach
        fun restoreSystemInputOutput() {
            System.setIn(systemIn)
            System.setOut(systemOut)
        }

        fun emitAndCollect(str: String, lambda: () -> Unit): String {
            provideInput(str)
            lambda.invoke()
            return output
        }

//        @Test
//        fun testCase1() {
//            val testString = "1 1"
//            provideInput(testString)
//            temp.main()
//            val scanner = Scanner(output)
//            assertEquals(scanner.nextInt(), 2)
//        }

//        @Test
//        fun testCase2() {
//            val testString = "2 2"
//            provideInput(testString)
//            main()
//            val scanner = Scanner(output)
//            assertEquals(scanner.nextInt(), 4)
//        }
//
//        @Test
//        fun testCase3() {
//            val str = emitAndCollect("3 3") { main() }
//            assertEquals(str.first().digitToInt(),6)
//        }
    }
}
