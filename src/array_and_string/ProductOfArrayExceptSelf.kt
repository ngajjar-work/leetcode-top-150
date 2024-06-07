package array_and_string

/**
 * 238. Product of Array Except Self
 * https://leetcode.com/problems/product-of-array-except-self/description
 */
class ProductOfArrayExceptSelf {

    fun productExceptSelf(nums: IntArray): IntArray {

        val result = IntArray(size = nums.size)
        var prefix = 1
        var postfix = 1

        //calculate prefix
        for (i in 0..nums.lastIndex) {
            result[i] = prefix
            prefix *= nums[i]
        }

        //calculate postfix
        for (i in nums.lastIndex downTo 0) {
            result[i] *= postfix
            postfix *= nums[i]
        }

        return result

    }
}