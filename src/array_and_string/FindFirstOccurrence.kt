package array_and_string

/***
 * 28. Find the Index of the First Occurrence in a String
 * https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string
 */
class FindFirstOccurrence {

    /**
     * This function finds the index of the first occurrence of the `needle` substring
     * within the `haystack` string using a simple substring comparison approach.
     *
     * @param haystack: The main string to search within.
     * @param needle: The substring to search for.
     * @return: The index of the first occurrence of the substring within the main string,
     *          or -1 if not found.
     */
    fun strStr(haystack: String, needle: String): Int {

        if (haystack == needle) {
            return 0 // Handle case where haystack and needle are equal
        }

        val stringLen = haystack.length
        val needleLen = needle.length
        var leftIndex = 0

        while (leftIndex <= stringLen - needleLen) {
            if (haystack.substring(leftIndex, leftIndex + needleLen) == needle) {
                return leftIndex
            }
            leftIndex++
        }

        return -1
    }

    /**
     * This function finds the index of the first occurrence of the `needle` substring
     * within the `haystack` string using a sliding window approach.
     *
     * @param haystack: The main string to search within.
     * @param needle: The substring to search for.
     * @return: The index of the first occurrence of the substring within the main string,
     *          or -1 if not found.
     */
    fun strStr1(haystack: String, needle: String): Int {

        var count = 0  // Keeps track of matching characters
        var index = 0  // Index in the haystack string

        while (index < haystack.length && count < needle.length) {
            if (haystack[index] == needle[count]) {
                count++  // Increment match count if characters match
            } else if (count > 0) {  // Mismatch after some matches
                index -= count  // Slide window back by the matched count
                count = 0        // Reset match count
            }
            index++  // Always move the window forward
        }

        return if (count == needle.length) index - count else -1 // Check if entire needle matched
    }
}