package com.ngajjarwork.designpatterns.daily_steak

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


/***
 * 1552. Magnetic Force Between Two Balls
 * https://leetcode.com/problems/magnetic-force-between-two-balls/description/
 */
class MagneticForceBetweenTwoBalls {

    fun maxDistance(position: IntArray, m: Int): Int {

        position.sort()

        // Binary search initialization
        var left = 0
        var right = position[position.lastIndex]

        var ans = 0

        while (left <= right) {
            val mid = left + (right - left) / 2
            if (canValidDistance(position, m, mid)) {
                ans = mid
                left = mid + 1
            } else {
                right = mid - 1
            }
        }

        return ans
    }

    private fun canValidDistance(position: IntArray, m: Int, distance: Int): Boolean {
        var totalBalls = 1
        var currentBallIndex = position[0]

        for (index in 1..position.lastIndex) {

            if (position[index] - currentBallIndex >= distance) {
                currentBallIndex = position[index]
                totalBalls++
            }

        }
        return totalBalls >= m
    }
}

class MagneticForceBetweenTwoBallsTest {

    private val uat = MagneticForceBetweenTwoBalls()

    @Test
    fun testInput() {
        Assertions.assertEquals(3, uat.maxDistance(intArrayOf(1, 2, 3, 4, 7), 3))
    }

    @Test
    fun testInput2() {
        Assertions.assertEquals(999999999, uat.maxDistance(intArrayOf(5, 4, 3, 2, 1, 1000000000), 2))
    }

    @Test
    fun testInput3() {
        Assertions.assertEquals(3, uat.maxDistance(intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), 4))
    }

}