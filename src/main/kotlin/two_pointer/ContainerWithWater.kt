package com.ngajjarwork.designpatterns.two_pointer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max
import kotlin.math.min

/***
 * 11. Container With Most Water
 * https://leetcode.com/problems/container-with-most-water
 */

class ContainerWithWater {

    /**
     * This function calculates the maximum area of water that can be contained within
     * a collection of containers represented by the `height` array.
     *
     * Steps (using two pointers):
     *  1. Initialize two pointers:
     *      - `left`: Starting index pointing to the leftmost container.
     *      - `right`: Ending index pointing to the rightmost container.
     *  2. Initialize a variable `maxArea` to keep track of the maximum area found so far.
     *  3. Iterate while `left` is less than `right`:
     *      - Calculate the potential container area using the current `left` and `right`
     *        indices and the minimum height between the containers at those indices.
     *      - Update `maxArea` if the calculated area is larger than the current `maxArea`.
     *      - Move the pointer with the shorter container height closer to the center:
     *          - If the height at `left` is greater than the height at `right`, decrement
     *            `right`.
     *          - Otherwise, increment `left`.
     *  4. After the loop completes, `maxArea` holds the maximum area of water that
     *     can be contained within the collection of containers.
     *
     * @param height: An array of integers representing the heights of the containers.
     * @return: The maximum area of water that can be contained within the containers.
     */
    fun maxArea(height: IntArray): Int {

        var left = 0
        var right = height.lastIndex
        var maxArea = 0

        while (left < right) {

            val currentArea = min(height[left], height[right]) * (right - left)  // Potential area
            maxArea = max(maxArea, currentArea)  // Update maxArea if larger

            if (height[left] > height[right]) {
                right--  // Move shorter container pointer
            } else {
                left++  // Move shorter container pointer
            }
        }
        return maxArea
    }
}


class ContainerWithWaterTest {

    private val containerWithWater = ContainerWithWater()

    @Test
    fun testInput() {

        val expected = 49  // Expected output for the test case

        val output = containerWithWater.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7))

        Assertions.assertEquals(expected, output)

    }
}

