package array_and_string

/**
 * 45. Jump Game II
 * https://leetcode.com/problems/jump-game-ii/
 *
 * Finds the minimum number of jumps needed to reach the end of an array.
 * You are allowed to jump at most the value at the current index.
 */
class JumpGame2 {

    /**
     * Calculates the minimum number of jumps required to reach the end of the array.
     *
     * @param nums The array of non-negative integers representing jump distances.
     * @return The minimum number of jumps needed to reach the end, or -1 if it's impossible.
     */
    fun jump(nums: IntArray): Int {
        // Minimum number of jumps required so far (initialized to 0)
        var jumps = 0

        // Index of the last element in the current jump window
        var currentEnd = 0

        // The furthest reachable index from the current position
        var furthestReachable = 0

        // Edge case: Array with only one element (already at the end)
        if (nums.size == 1) {
            return 0
        }

        // Iterate through the array
        for (i in nums.indices) {
            // Update the furthest reachable index based on the current element's jump distance
            furthestReachable = Math.max(furthestReachable, nums[i] + i)

            // If we reached the end of the current jump window
            if (i == currentEnd) {
                // Update the current end to the furthest reachable index
                currentEnd = furthestReachable
                // Increment the number of jumps required (since we reached the end of a window)
                jumps++

                // If the furthest reachable index is already the last element, we can reach the end
                if (furthestReachable == nums.lastIndex) {
                    return jumps
                }
            }
        }

        // If no solution is found (couldn't reach the end), return -1
        return -1
    }
}