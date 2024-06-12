package two_pointer

/***
 * 392. Is Subsequence
 * https://leetcode.com/problems/is-subsequence
 */

class IsSubsequence {

    /**
     * This function checks if a string `s` is a subsequence of another string `t`.
     * A subsequence is a sequence that can be derived from another sequence by deleting
     * some elements without changing the relative order of the remaining elements.
     * (e.g., "abc" is a subsequence of "abracadabra")
     *
     * Steps (using two pointers):
     *  1. Initialize two pointers:
     *      - `sIndex`: Starting index pointing to the beginning of the string `s`.
     *      - `tIndex`: Starting index pointing to the beginning of the string `t`.
     *  2. Iterate while both `sIndex` and `tIndex` are within their respective string lengths:
     *      - If the characters at `tIndex` (in `t`) and `sIndex` (in `s`) are equal, it means
     *        a character from `s` is found in `t`. Increment `sIndex` to move to the next
     *        character in `s`.
     *      - Increment `tIndex` to iterate through the string `t`.
     *  3. After the loop, if `sIndex` reaches the end of `s` (all characters matched), it
     *     means all characters in `s` were found in `t` in the correct order, so `s` is a
     *     subsequence of `t`. Return `true`.
     *  4. If the loop completes without finding all characters in `s`, it means `s` is not a
     *     subsequence of `t`. Return `false`.
     *
     * @param s: The shorter string to check if it's a subsequence.
     * @param t: The longer string to search within.
     * @return: True if `s` is a subsequence of `t`, false otherwise.
     */
    fun isSubsequence(s: String, t: String): Boolean {


        var sIndex = 0
        var tIndex = 0

        while (sIndex < s.length && tIndex < t.length) {
            if (t[tIndex] == s[sIndex]) sIndex++

            tIndex++
        }

        return sIndex == s.length
    }

    /**
     * This function checks if a string `s` is a subsequence of another string `t`.
     * (Alternative approach using forEach loop)
     *
     * Steps:
     *  1. Handle edge cases: If either `s` or `t` is empty, return `false`.
     *  2. Initialize a variable `stringCount` to keep track of remaining characters to match in `s`.
     *  3. Iterate through each character `c` in the string `t` using `forEach`:
     *      - If the current character `c` matches the character at `s.length - stringCount`
     *        (counting from the end of `s`), it means a character from `s` is found in `t`.
     *        Decrement `stringCount`.
     *      - If `stringCount` reaches 0 (all characters from `s` matched), it means `s` is a
     *        subsequence of `t`. Return `true`.
     *  4. If the loop completes without `stringCount` reaching 0, it means `s` is not a
     *     subsequence of `t`. Return `false`.
     *
     * @param s: The shorter string to check if it's a subsequence.
     * @param t: The longer string to search within.
     * @return: True if `s` is a subsequence of `t`, false otherwise.
     */
    fun isSubsequence2(s: String, t: String): Boolean {

        if (s.isEmpty() || t.isEmpty()) return false

        var stringCount = s.length
        t.forEach {
            if (it == s[s.length - stringCount]) stringCount--
            if (stringCount == 0)
                return true
        }
        return false
    }
}