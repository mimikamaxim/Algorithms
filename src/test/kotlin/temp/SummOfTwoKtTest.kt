package temp

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class SummOfTwoKtTest {

    @Test
    fun sumOfTwo() {
        assertEquals(temp.sumOfTwo(1,2),3)
        assertEquals(temp.sumOfTwo(0,2),2)
        assertEquals(temp.sumOfTwo(-1,2),1)
        assertEquals(temp.sumOfTwo(1,-2),-1)
        assertEquals(temp.sumOfTwo(3,2),5)
    }
}