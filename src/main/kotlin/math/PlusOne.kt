package com.ngajjarwork.designpatterns.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 66. Plus One
 * https://leetcode.com/problems/plus-one/description
 */
class PlusOne {

    fun plusOne(digits: IntArray): IntArray {
        val n = digits.size

        for (i in n - 1 downTo 0) {
            if (digits[i] < 9) {
                digits[i]++
                return digits
            }
            digits[i] = 0
        }

        val result = IntArray(n + 1)
        result[0] = 1
        return result
    }
}

class PlusOneTest {

    private val uat = PlusOne()

    @Test
    fun testInput1() {
        Assertions.assertArrayEquals(intArrayOf(1, 2, 4), uat.plusOne(intArrayOf(1, 2, 3)))
    }

    @Test
    fun testInput2() {
        Assertions.assertArrayEquals(intArrayOf(4, 3, 2, 2), uat.plusOne(intArrayOf(4, 3, 2, 1)))
    }

    @Test
    fun testInput3() {
        Assertions.assertArrayEquals(intArrayOf(1, 0), uat.plusOne(intArrayOf(9)))
    }

}