package array_and_string

/***
 * 55. Jump Game
 * https://leetcode.com/problems/jump-game/description/
 */
class JumpGame {

    /**
     * Checks if it's possible to jump from the beginning of the array to the end.
     *
     * @param nums The array of non-negative integers representing jump distances.
     * @return True if you can reach the end of the array by jumping, False otherwise.
     */
    fun canJump(nums: IntArray): Boolean {
        // Represents the furthest reachable index from the end (goal)
        var furthestReachableIndex = nums.lastIndex

        // Iterate backwards through the array starting from the second last element
        for (index in nums.lastIndex - 1 downTo 0) {
            // Check if the current element's jump distance can reach the furthest reachable index
            if (nums[index] + index >= furthestReachableIndex) {
                // Update the furthest reachable index to the current element's index
                furthestReachableIndex = index
            }
        }

        // If the furthest reachable index is 0 (beginning of the array), return true
        return furthestReachableIndex == 0
    }
}