package array_and_string

/***
 * 189. Rotate Array
 * https://leetcode.com/problems/rotate-array/description
 */
class RotateArray {

    /**
     * Rotates the elements of an array by a given number of positions (k) in place.
     * This approach uses the modulo operator (%) to handle rotations exceeding the array size.
     * It then utilizes a three-step reversal process to achieve the desired rotation.
     *
     * @param nums The array to rotate.
     * @param k The number of positions to rotate the elements (positive for right, negative for left).
     */
    fun rotate(nums: IntArray, k: Int) {

        val actualRotation = k % nums.size  // Handle rotations exceeding array size

        // Print the original array for debugging purposes (uncomment if needed)
        // println(nums.contentToString())

        reverseArray(nums, 0, nums.lastIndex)  // Reverse the entire array
        reverseArray(nums, 0, actualRotation - 1)  // Reverse the first part (up to k-1)
        reverseArray(nums, actualRotation, nums.lastIndex)  // Reverse the second part (from k to end)

        // Print the rotated array for debugging purposes (uncomment if needed)
        // println(nums.contentToString())
    }

    /**
     * Reverses the elements of a sub-array within a larger array.
     * This function is used as a helper function for the `rotate` function.
     *
     * @param nums The array containing the sub-array to reverse.
     * @param start The starting index of the sub-array.
     * @param end The ending index of the sub-array (inclusive).
     */
    private fun reverseArray(nums: IntArray, start: Int, end: Int) {
        var startIndex = start
        var endIndex = end

        while (startIndex < endIndex) {
            val temp = nums[startIndex]
            nums[startIndex] = nums[endIndex]
            nums[endIndex] = temp
            startIndex++
            endIndex--
        }
    }
}