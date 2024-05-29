package array_and_string

/***
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/description
 */

/***
 * 27. Remove Element
 * https://leetcode.com/problems/remove-element/description
 */
class RemoveElement {

    /**
     * Removes all occurrences of a given value from an array and returns the new length of the array.
     * This approach uses a forEach loop to iterate through the array and overwrite elements that are not equal to the target value.
     *
     * @param nums The array to modify.
     * @param val The value to remove.
     * @return The new length of the array after removing elements.
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var count = 0
        nums.forEach {
            if (it != `val`) {
                nums[count] = it
                count++
            }
        }
        return count
    }


    /**
     * Removes all occurrences of a given value from an array and returns the new length of the array (approach 2).
     * This approach uses two pointers, left and right, to iterate through the array.
     * It swaps elements that are not equal to the target value from the right side to the left side of the array.
     *
     * @param nums The array to modify.
     * @param val The value to remove.
     * @return The new length of the array after removing elements.
     */
    fun removeElement2(nums: IntArray, `val`: Int): Int {
        var leftIndex = 0
        var rightIndex = nums.lastIndex

        while (leftIndex <= rightIndex) {

            if (nums[leftIndex] == `val` && nums[rightIndex] != `val`) {
                val temp = nums[leftIndex]
                nums[leftIndex] = nums[rightIndex]
                nums[rightIndex] = temp
                leftIndex++
                rightIndex--
            } else if (nums[leftIndex] == `val` && nums[rightIndex] == `val`) {
                rightIndex--
            } else {
                leftIndex++
            }
        }
        // Uncomment this line to print the modified array for debugging purposes
        // println(nums.contentToString())
        return rightIndex + 1
    }
}