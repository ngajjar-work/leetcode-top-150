package array_and_string

/**
 * 58. Length of Last Word
 * https://leetcode.com/problems/length-of-last-word/
 */


class LengthOfLastWord {

    /**
     * This function iterates through the string in reverse order and counts characters
     * until a space is encountered. It keeps track of the word count and a flag indicating
     * if we're currently processing a word.
     *
     * @param s: The input string.
     * @return: The length of the last word in the string.
     */
    fun lengthOfLastWord(s: String): Int {
        var length = 0
        var inWord = false

        for (index in s.indices.reversed()) {
            if (s[index] != ' ') {
                length++
                inWord = true
            } else if (inWord) {
                break
            }
        }

        return length
    }

    /**
     * This alternative function uses a `forEachIndexed` loop to iterate through characters.
     * It maintains a `wordCount` and a `needToRecount` flag. If a non-space character is
     * encountered, it checks the `needToRecount` flag. If true (meaning a space was encountered
     * previously), it resets both `wordCount` and the flag. It then increments `wordCount`.
     * If a space is encountered, it sets the `needToRecount` flag to true.
     *
     * @param s: The input string.
     * @return: The length of the last word in the string.
     */
    fun lengthOfLastWord2(s: String): Int {
        var wordCount = 0
        var needToRecount = false

        s.toCharArray().forEachIndexed { index, c ->
            if (c != ' ') {
                if (needToRecount) {
                    needToRecount = false
                    wordCount = 0
                }
                wordCount++
            } else {
                needToRecount = true
            }
        }

        return wordCount
    }
}