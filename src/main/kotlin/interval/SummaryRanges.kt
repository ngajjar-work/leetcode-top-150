package com.ngajjarwork.designpatterns.interval

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 228. Summary Ranges
 * https://leetcode.com/problems/summary-ranges
 */
class SummaryRanges {


    fun summaryRanges(nums: IntArray): List<String> {
        val range = mutableListOf<String>()
        if (nums.isEmpty()) return range

        var start = nums[0]

        for (i in 1..nums.size) {
            // Check if we're at the end of the array or the current number is not consecutive
            if (i == nums.size || nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    range.add("$start")
                } else {
                    range.add("$start->${nums[i - 1]}")
                }
                if (i < nums.size) {
                    start = nums[i]
                }
            }
        }

        return range
    }


    fun summaryRanges2(nums: IntArray): List<String> {
        val range = mutableListOf<String>()

        if (nums.isEmpty()) return range

        var start = nums[0]

        for (i in 1 until nums.size) {
            if (nums[i] != nums[i - 1] + 1) {
                if (start == nums[i - 1]) {
                    range.add("$start")
                } else {
                    range.add("$start->${nums[i - 1]}")
                }
                start = nums[i]
            }
        }

        // Add the last range
        if (start == nums.last()) {
            range.add("$start")
        } else {
            range.add("$start->${nums.last()}")
        }

        return range
    }

    fun summaryRanges3(nums: IntArray): List<String> {

        val range = mutableListOf<String>()

        if (nums.size == 1) {
            return listOf(nums[0].toString())
        } else if (nums.size > 1) {
            var count = 0

            for (index in 0..nums.lastIndex) {

                if (index + 1 < nums.size && nums[index + 1] - nums[index] == 1) {
                    count++
                } else {
                    if (count == 0) {
                        range.add(nums[index].toString())
                    } else {
                        range.add("${nums[index - count]}->${nums[index]}")
                    }
                    count = 0
                }
            }
        }
        return range
    }

}

class SummaryRangesTest {

    private val uat = SummaryRanges()

    @Test
    fun testInput1() {
        Assertions.assertEquals(
            listOf("0->2", "4->5", "7").joinToString(),
            uat.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)).joinToString()
        )
    }


    @Test
    fun testInput2() {
        Assertions.assertEquals(
            listOf("0", "2->4", "6", "8->9").joinToString(),
            uat.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)).joinToString()
        )
    }

}