package com.ngajjarwork.designpatterns.daily_steak

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

/**
 * 826. Most Profit Assigning Work
 * https://leetcode.com/problems/most-profit-assigning-work/description
 */

class MostProfitAssigningWork {

    fun maxProfitAssignment(difficulty: IntArray, profit: IntArray, worker: IntArray): Int {

        // Initialize an array that holds profit information
        val maxDifficulty = difficulty.maxOrNull() ?: 0
        val maxProfitArray = IntArray(maxDifficulty + 1) { 0 }

        // Map profit for difficulty
        for (i in difficulty.indices) {
            maxProfitArray[difficulty[i]] = max(profit[i], maxProfitArray[difficulty[i]])
        }

        // Ensure maxProfitArray holds the maximum profit up to each difficulty
        for (i in 1..maxProfitArray.lastIndex) {
            maxProfitArray[i] = max(maxProfitArray[i], maxProfitArray[i - 1])
        }

        var finalProfit = 0

        // Calculate the total maximum profit based on the workers' abilities
        for (w in worker) {
            finalProfit += if (w >= maxProfitArray.size) {
                maxProfitArray[maxProfitArray.lastIndex]
            } else {
                maxProfitArray[w]
            }
        }
        return finalProfit
    }
}

class MostProfitAssigningWorkTest {

    private val uat = MostProfitAssigningWork()

    @Test
    fun testInput() {

        val difficulty = intArrayOf(2, 4, 6, 8, 10)
        val profit = intArrayOf(10, 20, 30, 40, 50)
        val worker = intArrayOf(4, 5, 6, 7)

        val expected = 100
        val output = uat.maxProfitAssignment(difficulty, profit, worker)

        Assertions.assertEquals(expected, output)
    }

    @Test
    fun testInput2() {

        val difficulty = intArrayOf(68, 35, 52, 47, 86)
        val profit = intArrayOf(67, 17, 1, 81, 3)
        val worker = intArrayOf(92, 10, 85, 84, 82)

        val expected = 324
        val output = uat.maxProfitAssignment(difficulty, profit, worker)

        Assertions.assertEquals(expected, output)
    }
}