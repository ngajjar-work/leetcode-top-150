package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 219. Contains Duplicate II
 * https://leetcode.com/problems/contains-duplicate-ii/description
 */
class ContainsDuplicate2 {


    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {

        val numIndices = hashMapOf<Int, Int>()

        for (i in nums.indices) {
            val num = nums[i]
            if (numIndices.containsKey(num) && i - numIndices[num]!! <= k) {
                return true
            }
            numIndices[num] = i
        }

        return false
    }

}

class ContainsDuplicate2Test {

    private val uat = ContainsDuplicate2()

    @Test
    fun testInput() {
        Assertions.assertTrue(uat.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    }

    @Test
    fun testInput2() {
        Assertions.assertTrue(uat.containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    }

    @Test
    fun testInput3() {
        Assertions.assertFalse(uat.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    }
}