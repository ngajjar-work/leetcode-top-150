package com.ngajjarwork.designpatterns.two_pointer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/***
 * 15. 3Sum
 * https://leetcode.com/problems/3sum
 */

class ThreeSum {

    /**
     * This function finds all unique triplets of numbers in a sorted `nums` array
     * that add up to zero.
     *
     * Steps:
     *  1. Initialize a `mutableSetOf` named `output` to store the unique triplets.
     *  2. Sort the `nums` array to enable efficient searching using two pointers.
     *  3. Iterate through the `nums` array using an index `index`:
     *      - Check for duplicates: If the current element `nums[index]` is the same
     *        as the previous element (`index > 0` check), skip to the next element
     *        and continue the loop.
     *      - Initialize two pointers:
     *          - `left`: Starting index pointing to the element after `index`.
     *          - `right`: Ending index pointing to the last element of the array.
     *      - Iterate while `left` is less than `right`:
     *          - Calculate the sum of the current element `nums[index]`, `nums[left]`,
     *            and `nums[right]`.
     *          - If the sum is zero, it's a valid triplet! Add the triplet `[nums[index],
     *            nums[left], nums[right]]` to the `output` set.
     *          - If the sum is greater than zero, move `right` pointer down (decrement)
     *            to decrease the sum towards zero.
     *          - If the sum is less than zero, move `left` pointer up (increment)
     *            to increase the sum towards zero.
     *  4. After iterating through the entire array, `output` will contain all unique
     *     triplets that add up to zero. Convert the `output` set to a list and return it.
     *
     * @param nums: The sorted integer array to search within.
     * @return: A list of all unique triplets (as lists) that add up to zero, or an empty
     *          list if no such triplets exist.
     */
    fun threeSum(nums: IntArray): List<List<Int>> {


        val output = mutableSetOf<List<Int>>()

        //sort array
        nums.sort()

        var index = 0

        while (index <= nums.lastIndex - 2) {

            if (index > 0 && nums[index] == nums[index - 1]) {
                index++
                continue
            }

            var left = index + 1
            var right = nums.lastIndex


            while (left < right) {

                if (nums[index] + nums[left] + nums[right] == 0) {
                    output.add(listOf(nums[index], nums[left], nums[right]))
                    left++
                    right--
                } else if (nums[index] + nums[left] + nums[right] > 0) {
                    right--
                } else {
                    left++
                }
            }
            index++
        }
        return output.toList()
    }
}

class ThreeSumTest {

    private val threeSum = ThreeSum()

    @Test
    fun testInput() {

        val input = intArrayOf(-1, 0, 1, 2, -1, -4)

        val actualOutput = threeSum.threeSum(input).joinToString(",")  // Convert list to comma-separated string
        val expectedOutput = listOf(listOf(-1, -1, 2), listOf(-1, 0, 1)).joinToString(",")

        Assertions.assertEquals(expectedOutput, actualOutput)

    }

    @Test
    fun testInput2() {

        val input = intArrayOf(-2, 0, 0, 2, 2)

        val actualOutput = threeSum.threeSum(input).joinToString(",")
        val expectedOutput = listOf(listOf(-2, 0, 2)).joinToString(",")

        Assertions.assertEquals(expectedOutput, actualOutput)

    }
}