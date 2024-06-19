package com.ngajjarwork.designpatterns.daily_steak

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 1482. Minimum Number of Days to Make m Bouquets
 * https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets
 */

class BloomDayCalculator {

    fun minDays(bloomDay: IntArray, m: Int, k: Int): Int {

        // Return if it requires more flowers than possible
        if (m * k > bloomDay.size) {
            return -1
        }

        // Binary search initialization
        var left = bloomDay.minOrNull() ?: 0
        var right = bloomDay.maxOrNull() ?: 0

        while (left < right) {
            val mid = left + (right - left) / 2
            if (canMakeBouquets(bloomDay, m, k, mid)) {
                right = mid
            } else {
                left = mid + 1
            }
        }

        // Check if the final left bound can make m bouquets
        return if (canMakeBouquets(bloomDay, m, k, left)) left else -1
    }

    private fun canMakeBouquets(bloomDay: IntArray, m: Int, k: Int, days: Int): Boolean {
        var bouquets = 0
        var flowers = 0

        for (day in bloomDay) {
            if (day <= days) {
                flowers++
                if (flowers == k) {
                    bouquets++
                    flowers = 0
                }
            } else {
                flowers = 0
            }
            if (bouquets >= m) {
                return true
            }
        }

        return bouquets >= m
    }

}


class BloomDayCalculatorTest {

    private val uat = BloomDayCalculator()

    @Test
    fun testInput() {

        val output = uat.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 1)

        Assertions.assertEquals(3, output)
    }

    @Test
    fun testInput2() {

        val output = uat.minDays(intArrayOf(1, 10, 3, 10, 2), 3, 2)

        Assertions.assertEquals(-1, output)
    }

    @Test
    fun testInput3() {

        val output = uat.minDays(intArrayOf(7, 7, 7, 7, 12, 7, 7), 2, 3)

        Assertions.assertEquals(12, output)
    }
}