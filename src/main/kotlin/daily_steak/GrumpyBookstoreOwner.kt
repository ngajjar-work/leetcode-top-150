package com.ngajjarwork.designpatterns.daily_steak

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 1052. Grumpy Bookstore Owner
 * https://leetcode.com/problems/grumpy-bookstore-owner/description
 */
class GrumpyBookstoreOwner {

    fun maxSatisfied(customers: IntArray, grumpy: IntArray, minutes: Int): Int {
        val n = customers.size
        var satisfiedCustomers = 0

        // Calculate the baseline satisfaction
        for (i in 0 until n) {
            if (grumpy[i] == 0) {
                satisfiedCustomers += customers[i]
            }
        }

        // Calculate the potential extra satisfaction in the first window
        var extraSatisfaction = 0
        for (i in 0 until minutes) {
            if (grumpy[i] == 1) {
                extraSatisfaction += customers[i]
            }
        }

        // Use a sliding window to find the maximum extra satisfaction
        var maxExtraSatisfaction = extraSatisfaction
        for (i in minutes until n) {
            if (grumpy[i] == 1) {
                extraSatisfaction += customers[i]
            }
            if (grumpy[i - minutes] == 1) {
                extraSatisfaction -= customers[i - minutes]
            }
            maxExtraSatisfaction = maxOf(maxExtraSatisfaction, extraSatisfaction)
        }

        // The total maximum satisfaction
        return satisfiedCustomers + maxExtraSatisfaction
    }
}

class GrumpyBookstoreOwnerTest {
    private val uat = GrumpyBookstoreOwner()

    @Test
    fun testInput() {

        Assertions.assertEquals(
            16,
            uat.maxSatisfied(
                intArrayOf(1, 0, 1, 2, 1, 1, 7, 5),
                intArrayOf(0, 1, 0, 1, 0, 1, 0, 1),
                3
            )
        )
    }

    @Test
    fun testInput2() {

        Assertions.assertEquals(
            1,
            uat.maxSatisfied(
                intArrayOf(1),
                intArrayOf(0),
                1
            )
        )
    }

}