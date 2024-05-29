package array_and_string

/***
 * 88. Merge Sorted Array
 * https://leetcode.com/problems/merge-sorted-array/description/
 */
class MergeSortedArray {

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): IntArray {

        //we will start from end
        var k = m + n - 1
        var num1Index = m - 1
        var num2Index = n - 1


        while (num2Index >= 0) {

            if (num1Index >= 0 && nums1[num1Index] > nums2[num2Index]) {
                nums1[k] = nums1[num1Index] //copy the biggest number from num1
                num1Index--
            } else {
                nums1[k] = nums2[num2Index] //copy the biggest number from num2
                num2Index--
            }
            k--
        }

        return nums1
    }
}