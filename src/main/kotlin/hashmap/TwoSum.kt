package hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 1. Two Sum
 * https://leetcode.com/problems/two-sum/description
 */
class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val valueDiffMap = hashMapOf<Int, Int>()
        for ((index, num) in nums.withIndex()) {
            if (valueDiffMap[num] != null) {
                return intArrayOf(valueDiffMap[num]!!, index)
            } else {
                valueDiffMap[target - num] = index
            }
        }
        return IntArray(2)
    }
}

class TwoSumTest {

    private val uat = TwoSum()

    @Test
    fun testInput() {
        Assertions.assertArrayEquals(intArrayOf(0, 1), uat.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }


    @Test
    fun testInput2() {

        Assertions.assertArrayEquals(intArrayOf(1, 2), uat.twoSum(intArrayOf(3, 2, 4), 6))
    }
}
