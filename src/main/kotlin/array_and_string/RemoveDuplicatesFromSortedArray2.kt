package array_and_string

/***
 * 80. Remove Duplicates from Sorted Array II
 * https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/description
 */
class RemoveDuplicatesFromSortedArray2 {

    /**
     * Removes duplicate elements from a sorted array, allowing each element to appear at most twice.
     * This approach uses a loop to iterate through the array and keeps track of a "count" variable.
     * It only adds elements to the array if they are different from the previous element or if it's the second occurrence of the same element.
     *
     * @param nums The sorted array to modify.
     * @return The new length of the array after removing duplicates exceeding two occurrences.
     */
    fun removeDuplicates(nums: IntArray): Int {
        var count = 0  // Tracks the index for non-duplicate or allowed duplicate elements
        nums.forEach { value ->
            if (count < 2 || nums[count - 1] != value) {  // Check for first occurrence or allowed second occurrence
                nums[count++] = value
            }
        }
        // Uncomment this line to print the modified array for debugging purposes
        // println(nums.contentToString())
        return count
    }

    /**
     * Removes duplicate elements from a sorted array, allowing each element to appear at most twice (alternative approach).
     * This approach uses a loop to iterate through the array and keeps track of a "count" and "duplicateCount" variable.
     * It allows adding the element twice and then resets the duplicate counter for the next element.
     *
     * @param nums The sorted array to modify.
     * @return The new length of the array after removing duplicates exceeding two occurrences.
     */
    fun removeDuplicates2(nums: IntArray): Int {
        var count = 0
        var duplicateCount = 0

        nums.forEachIndexed { index, value ->
            if (index == 0) {  // Handle the first element (always unique)
                nums[count] = value
                count++
                return@forEachIndexed
            }

            if (nums[index - 1] != value) {  // Check if current element is different from the previous one
                nums[count] = value
                count++
                duplicateCount = 0  // Reset duplicate counter for a new element
            } else if (nums[index - 1] == value && duplicateCount < 1) {  // Allow second occurrence
                nums[count] = value
                count++
                duplicateCount++
            }
        }

        // Uncomment this line to print the modified array for debugging purposes
        // println(nums.contentToString())
        return count
    }
}