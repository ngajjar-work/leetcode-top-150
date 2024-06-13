package two_pointer

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 167. Two Sum II - Input Array Is Sorted
 * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
 */
class TwoSum2 {

    /**
     * This function finds the indices of two numbers in a sorted integer array `numbers`
     * that add up to a given target `target`.
     *
     * Steps (using two pointers):
     *  1. Initialize two pointers:
     *      - `leftIndex`: Starting index pointing to the beginning of the array.
     *      - `rightIndex`: Ending index pointing to the last element of the array.
     *  2. Iterate while `leftIndex` is less than `rightIndex`:
     *      - Calculate the sum of the elements at `leftIndex` and `rightIndex`.
     *      - If the sum is equal to the `target`:
     *          - We have found the two numbers! Return an array containing the indices
     *            of the elements (plus 1 for 1-based indexing).
     *      - If the sum is less than the `target`, it means we need a larger number.
     *        Increment `leftIndex` to move towards larger elements.
     *      - If the sum is greater than the `target`, it means we need a smaller number.
     *        Decrement `rightIndex` to move towards smaller elements.
     *  3. If the loop completes without finding a pair that adds up to the target,
     *     return an empty array to indicate no such pair exists.
     *
     * @param numbers: The sorted integer array to search within.
     * @param target: The target sum to find.
     * @return: An array containing the indices (1-based) of the two numbers that add up to
     *          the target, or an empty array if no such pair exists.
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {

        var leftIndex = 0
        var rightIndex = numbers.lastIndex

        while (leftIndex < rightIndex) {
            val total = numbers[leftIndex] + numbers[rightIndex]
            if (total == target) {
                return intArrayOf(leftIndex + 1, rightIndex + 1) // Return 1-based indices
            } else if (total < target) {
                leftIndex++
            } else {
                rightIndex--
            }
        }

        return IntArray(2) // Empty array to indicate no such pair exists
    }
}


class TwoSum2Test {

    private val twoSum2 = TwoSum2()  // Create an instance of TwoSum2 for testing

    @Test
    fun testInputs() {
        val expected = intArrayOf(2, 4) // Expected output for this test case

        // User-case 1: Test with input array {1, 2, 4, 7} and target 9
        val output = twoSum2.twoSum(intArrayOf(1, 2, 4, 7), 9)
        Assertions.assertEquals(expected.contentToString(), output.contentToString())
    }
}