package array_and_string

/***
 * 151. Reverse Words in a String
 * https://leetcode.com/problems/reverse-words-in-a-string
 */

class ReverseWordsInAString {

    /**
     * This function reverses the order of words in a given string.
     *
     * Steps:
     * 1. Trim any leading or trailing whitespace from the input string.
     * 2. Split the trimmed string into an array of words using a regular expression
     *    matching one or more spaces (" +").
     * 3. Check if there's only one word. If so, return the word as there's nothing to reverse.
     * 4. Initialize a StringBuilder object to efficiently build the reversed string.
     * 5. Iterate through the words array in reverse order (lastIndex down to 0).
     *    - Append each word to the StringBuilder.
     *    - Append a space after each word (except the last one).
     * 6. Convert the StringBuilder content to a String and return it.
     *
     * @param s: The input string.
     * @return: The string with the order of words reversed.
     */
    fun reverseWords(s: String): String {

        // 1. Trim and split the string into words
        val subString = s.trim().split(Regex(" +"))

        // 2. Handle single word case
        if (subString.size == 1) {
            return subString[0]
        }

        // 3. Build the reversed string
        val stringBuilder = StringBuilder()
        for (index in subString.lastIndex downTo 0) {
            stringBuilder.append(subString[index])
            stringBuilder.append(" ")
        }

        // 4. Remove the trailing space (if any) and return the reversed string
        return stringBuilder.toString().trim()
    }
}