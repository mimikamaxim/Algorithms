package Ya_4_0.HW1

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class TaskA_partition_cleanKtTest {
    @Test
    fun myPartition() {
        val testArr1 = intArrayOf(1, 9, 4, 2, 3)
        val pivot1 = 3
        assertEquals(Pair(2,3),TaskA_partition_clean.partition(testArr1,pivot1,0,testArr1.size))
        val testArr2 = intArrayOf()
        val pivot2 = 0
        assertEquals(Pair(0,0),TaskA_partition_clean.partition(testArr2,pivot2,0,testArr2.size))
        val testArr3 = intArrayOf(0)
        val pivot3 = 0
        assertEquals(Pair(0,1), TaskA_partition_clean.partition(testArr3,pivot3,0,testArr3.size))
        val testArr4 = intArrayOf(0)
        val pivot4 = 1
        assertEquals(Pair(1,1), TaskA_partition_clean.partition(testArr4,pivot4,0,testArr4.size))
    }
}