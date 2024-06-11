package two_pointer

/***
 * 125. Valid Palindrome
 * https://leetcode.com/problems/valid-palindrome/description
 */

class ValidPalindrome {

    /**
     * This function checks if a given string (`s`) is a palindrome.
     * A palindrome is a word or phrase that reads the same backward as forward.
     * (e.g., "racecar", "madam")
     *
     * Steps:
     *  1. Initialize two pointers:
     *      - `left`: Starting index pointing to the beginning of the string.
     *      - `right`: Ending index pointing to the last character of the string.
     *  2. Iterate while `left` is less than `right`:
     *      - Check if both characters at `left` and `right` are letters or digits using
     *        `isLetterOrDigit` function.
     *      - If both are letters or digits:
     *          - Convert both characters to uppercase for case-insensitive comparison.
     *          - If the uppercase characters are equal, move both pointers one step closer
     *            to the center (increment `left` and decrement `right`).
     *          - If the uppercase characters are not equal, the string is not a palindrome,
     *            return `false`.
     *      - If the character at `left` is not a letter or digit, increment `left`.
     *      - If the character at `right` is not a letter or digit, decrement `right`.
     *  3. If the loop completes without returning `false`, it means all characters compared
     *     were valid and matched, so the string is a palindrome. Return `true`.
     *
     * @param s: The input string.
     * @return: True if the string is a palindrome, false otherwise.
     */
    fun isPalindrome(s: String): Boolean {

        var left = 0
        var right = s.lastIndex

        while (left < right) {
            if (s[left].isLetterOrDigit() && s[right].isLetterOrDigit()) {
                if (s[left].uppercase() == s[right].uppercase()) {
                    left++
                    right--
                } else {
                    return false
                }
            } else {
                if (!s[left].isLetterOrDigit()) left++
                if (!s[right].isLetterOrDigit()) right--
            }
        }

        return true
    }
}