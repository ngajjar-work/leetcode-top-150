package com.ngajjarwork.designpatterns.sliding_window

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.min

/**
 * 209. Minimum Size Subarray Sum
 * https://leetcode.com/problems/minimum-size-subarray-sum
 */
class MinimumSizeSubArraySum {

    /**
     * This function finds the minimum size subarray in the `nums` array
     * where the sum of its elements is greater than or equal to the target `target`.
     *
     * Uses a sliding window approach with two pointers (`low` and `high`):
     *  1. Initialize variables:
     *      - `currentSum`: Stores the sum of elements within the current window.
     *      - `minWindowSize`: Stores the minimum size window found so far (initialized to MAX_VALUE).
     *  2. Iterate using a `high` pointer from 0 to the end of the `nums` array:
     *      - Add the element at `high` to `currentSum`.
     *      - Increment `high` to expand the window.
     *  3. Use a nested loop with a `low` pointer:
     *      - While `currentSum` is greater than or equal to `target`:
     *          - Calculate the current window size (`high - low`).
     *          - Update `minWindowSize` if the current window size is smaller.
     *          - Subtract the element at `low` from `currentSum`.
     *          - Increment `low` to shrink the window from the left.
     *  4. After iterating through the entire array, `minWindowSize` will hold the
     *     minimum size subarray that satisfies the condition. Return it.
     *     - If no such subarray exists, return 0.
     *
     * @param target: The target sum to achieve within a subarray.
     * @param nums: The integer array to search within.
     * @return: The minimum size subarray (length) that adds up to a sum greater than
     *          or equal to `target`, or 0 if no such subarray exists.
     */
    fun minSubArrayLen(target: Int, nums: IntArray): Int {

        var currentSum = 0
        var minWindowSize = Int.MAX_VALUE

        // Two pointers for sliding window
        var high = 0
        var low = 0

        while (high < nums.size) {

            currentSum += nums[high]
            high++

            while (currentSum >= target) {
                val currentWindow = high - low
                minWindowSize = min(minWindowSize, currentWindow)
                currentSum -= nums[low]
                low++
            }
        }
        return if (minWindowSize == Int.MAX_VALUE) 0 else minWindowSize
    }

    /**
     * Less efficient solution using a separate loop to adjust window size.
     * Not recommended due to higher time complexity.
     *
     * This solution iterates through the array with a window size (`windowSize`)
     * that expands from 1 to the entire array length.
     *
     * It maintains a sum (`sum`) of elements within the current window and
     * adjusts the window using two indices (`index` and `windowSize`).
     *
     * @param target: The target sum to achieve within a subarray.
     * @param nums: The integer array to search within.
     * @return: The minimum size subarray (length) that adds up to a sum greater than
     *          or equal to `target`, or 0 if no such subarray exists.
     */
    fun minSubArrayLen2(target: Int, nums: IntArray): Int {

        var windowSize = 1
        var index = 0
        var sum = 0

        while (windowSize <= nums.size) {

            sum += nums[index]

            if (index >= windowSize) {
                sum -= nums[index - windowSize]
            }

            if (index + 1 >= windowSize && sum >= target) {
                return windowSize
            }

            index++

            if (index == nums.size) {
                index = 0
                sum = 0
                windowSize++
            }
        }
        return 0
    }
}

class MinimumSizeSubArraySumTest {

    private val minimumSizeSubArraySum = MinimumSizeSubArraySum()

    @Test
    fun testInput() {

        val expectedOutput = 2
        val actualOutput = minimumSizeSubArraySum.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3))

        Assertions.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testInput2() {

        val expectedOutput = 3
        val actualOutput = minimumSizeSubArraySum.minSubArrayLen(11, intArrayOf(1, 2, 3, 4, 5))

        Assertions.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testInput3() {

        val expectedOutput = 5
        val actualOutput = minimumSizeSubArraySum.minSubArrayLen(15, intArrayOf(1, 2, 3, 4, 5))

        Assertions.assertEquals(expectedOutput, actualOutput)
    }


}
