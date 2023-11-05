package Ya_4_0.HW1

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

internal class TaskB_qSortKtTest {
    @Test
    fun testQSort() {
        var test = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, -1)
        TaskB_qSort.qSort(test, 0, test.size)
        assertTrue(intArrayOf(-1, 1, 1, 1, 1, 1, 1, 1, 1, 1).contentEquals(test))

        test = intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1)
        TaskB_qSort.qSort(test, 0, test.size)
        assertTrue(intArrayOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1).contentEquals(test))

        test = intArrayOf(1, 2, 8, 2, 3)
        TaskB_qSort.qSort(test, 0, test.size)
        assertTrue(intArrayOf(1, 2, 2, 3, 8).contentEquals(test))

        test = intArrayOf()
        TaskB_qSort.qSort(test, 0, test.size)
        assertTrue(intArrayOf().contentEquals(test))

        test = intArrayOf(0)
        TaskB_qSort.qSort(test, 0, test.size)
        assertTrue(intArrayOf(0).contentEquals(test))

        test = intArrayOf(1, 5, 2, 4, 3)
        TaskB_qSort.qSort(test, 0, test.size)
        assertTrue(intArrayOf(1, 2, 3, 4, 5).contentEquals(test))
    }
}