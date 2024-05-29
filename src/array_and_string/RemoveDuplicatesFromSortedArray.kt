package array_and_string

/***
 * 26. Remove Duplicates from Sorted Array
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description
 */
class RemoveDuplicatesFromSortedArray {

    /**
     * Removes duplicate elements from a sorted array and returns the new length of the array.
     * This approach uses a loop to iterate through the array and keeps track of a "count" variable.
     * It only adds elements to the array if they are different from the previous element.
     *
     * @param nums The sorted array to modify.
     * @return The new length of the array after removing duplicates.
     */
    fun removeDuplicates(nums: IntArray): Int {
        var count = 0  // Tracks the index for non-duplicate elements
        nums.forEachIndexed { index, value ->
            if (index == 0) {  // Handle the first element (always unique)
                count++
                return@forEachIndexed  // Exit the loop after adding the first element
            }

            if (nums[index - 1] != value) {  // Check if current element is different from the previous one
                nums[count] = value  // Add unique element to the array
                count++
            }
        }
        // Uncomment this line to print the modified array for debugging purposes
        // println(nums.contentToString())
        return count
    }
}