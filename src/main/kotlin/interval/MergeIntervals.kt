package com.ngajjarwork.designpatterns.interval

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

/**
 * 56. Merge Intervals
 * https://leetcode.com/problems/merge-intervals/description
 */
class MergeIntervals {

    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        if (intervals.size <= 1) {
            return intervals
        }

        // Sort the intervals by their start times
        intervals.sortBy { it[0] }

        // Create a result list to store the merged intervals
        val result = mutableListOf<IntArray>()
        var currentInterval = intervals[0]

        // Iterate through the sorted intervals and merge as necessary
        for (i in 1 until intervals.size) {
            val nextInterval = intervals[i]

            // Check if the current interval overlaps with the next interval
            if (currentInterval[1] >= nextInterval[0]) {
                // Merge the intervals by updating the end of the current interval
                currentInterval[1] = maxOf(currentInterval[1], nextInterval[1])
            } else {
                // Add the current interval to the result list and move to the next interval
                result.add(currentInterval)
                currentInterval = nextInterval
            }
        }

        // Add the last interval to the result list
        result.add(currentInterval)

        return result.toTypedArray()
    }

    fun merge1(intervals: Array<IntArray>): Array<IntArray> {

        if (intervals.size <= 1) {
            return intervals
        }

        intervals.sortBy { it.first() }

        val mergedIndex = mutableListOf<Int>()

        var index = 0
        var nextIndex = 1

        while (index < intervals.size - 1) {

            if (!mergedIndex.contains(index)) {
                if (intervals[index][1] in intervals[nextIndex][0]..intervals[nextIndex][1] ||
                    intervals[nextIndex][1] in intervals[index][0]..intervals[index][1]
                ) {
                    intervals[index][1] = max(intervals[index][1], intervals[nextIndex][1])
                    mergedIndex.add(nextIndex)
                }
                nextIndex++
            }

            if (mergedIndex.contains(index) || nextIndex == intervals.size) {
                index++
                nextIndex = index + 1
            }
        }

        val result = Array(intervals.size - mergedIndex.size) { intArrayOf(2) }
        result[0] = intervals[0]
        index = 1
        for (i in 1..intervals.lastIndex) {

            if (!mergedIndex.contains(i)) {
                result[index] = intervals[i]
                index++
            }
        }

        return result
    }
}

class MergeIntervalsTest {

    private val uat = MergeIntervals()

    @Test
    fun testInput() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(1, 6), intArrayOf(8, 10), intArrayOf(15, 18)),
            uat.merge(arrayOf(intArrayOf(1, 3), intArrayOf(2, 6), intArrayOf(8, 10), intArrayOf(15, 18))),
        )
    }

    @Test
    fun testInput2() {
        Assertions.assertArrayEquals(
            arrayOf(intArrayOf(1, 4)),
            uat.merge(arrayOf(intArrayOf(1, 4), intArrayOf(2, 3)))
        )
    }
}