package array_and_string

/***
 * 169. Majority Element
 * https://leetcode.com/problems/majority-element/description
 */
class MajorityElement {

    /**
     * Finds the element that appears more than half the times in a given array using Moore's Voting Algorithm.
     * This algorithm leverages the fact that the majority element must cancel out all non-majority elements during counting.
     *
     * @param nums The array to search for the majority element.
     * @return The majority element if it exists, otherwise throws an exception (consider adding null handling in practice).
     */
    fun majorityElement(nums: IntArray): Int {
        var candidate = 0
        var point = 0

        for (i in 0..nums.lastIndex) {

            if (point == 0) {
                candidate = nums[i]
            }

            if (nums[i] == candidate) {
                point++
            } else {
                point--
            }
        }
        return candidate
    }

    /**
     * Finds the element that appears more than half the times in a given array (alternative approach).
     * This approach sorts the array and then checks if the count of the current element is greater than half the array size.
     *
     * @param nums The array to search for the majority element.
     * @return The majority element if it exists, otherwise throws an exception (consider adding null handling in practice).
     */
    fun majorityElement2(nums: IntArray): Int {

        nums.sort()

        var count = 0
        var lastValue = 0

        nums.forEachIndexed { index, it ->
            if (index < 1) {
                count++
                lastValue = it
            } else if (lastValue == it) {
                count++
            } else if (it == nums[index - 1] && count > 0) {
                count--
            }

            if (count <= 0) {
                lastValue = it
            }
        }
        return lastValue
    }
}