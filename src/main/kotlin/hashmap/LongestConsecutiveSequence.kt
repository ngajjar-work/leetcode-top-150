package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

/**
 * 128. Longest Consecutive Sequence
 * https://leetcode.com/problems/longest-consecutive-sequence
 */

class LongestConsecutiveSequence {

    fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) {
            return 0
        }

        val set = nums.toHashSet()

        var longestStreak = 0

        for (num in set) {
            // Only start a sequence if `num - 1` is not in the set
            if (!set.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1

                while (set.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                }

                longestStreak = max(longestStreak, currentStreak)
            }
        }

        return longestStreak
    }

    fun longestConsecutive2(nums: IntArray): Int {

        if (nums.isEmpty()) {
            return 0
        }

        val set = hashSetOf<Int>()

        //add number into hashset
        nums.forEach {
            set.add(it)
        }

        var count = 1

        nums.forEach {

            var num = it
            var numCount = 1


            while (num > Int.MIN_VALUE) {

                if (set.contains(num - 1)) {
                    numCount++
                    num++
                } else {
                    break
                }
            }
            count = max(count, numCount)
        }

        return count
    }
}

class LongestConsecutiveSequenceTest {
    private val uat = LongestConsecutiveSequence()

    @Test
    fun testInput1() {
        Assertions.assertEquals(4, uat.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    }


    @Test
    fun testInput2() {
        Assertions.assertEquals(9, uat.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    }

    @Test
    fun testInput3() {
        Assertions.assertEquals(1, uat.longestConsecutive(intArrayOf(0)))
    }

    @Test
    fun testInput4() {
        Assertions.assertEquals(0, uat.longestConsecutive(intArrayOf()))
    }
}
