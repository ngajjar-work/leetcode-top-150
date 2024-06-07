package array_and_string

/**
 * 13. Roman to Integer
 * https://leetcode.com/problems/roman-to-integer/description
 */
class RomanToInteger {

    /**
     * Converts a Roman numeral string to an integer value.
     * This version iterates through the string and handles subtractions (IV, IX, XL, XC).
     *
     * @param s The Roman numeral string.
     * @return The integer value represented by the Roman numeral.
     */
    fun romanToInt(s: String): Int {
        var index = 0
        var sum = 0

        while (index < s.length) {
            val currentValue = s[index].romanCharToInt() // Get current value using extension function
            val nextValue =
                if (index < s.lastIndex) s[index + 1].romanCharToInt() else 0 // Check for next value (avoiding out-of-bounds)
            if (nextValue > currentValue && (currentValue == 1 || currentValue == 10)) { // Handle subtractions only for I and X
                sum += nextValue - currentValue
                index++ // Skip next character after subtraction
            } else {
                sum += currentValue
            }
            index++
        }

        return sum
    }

    /**
     * Converts a Roman numeral string to an integer value.
     * This version iterates through the string backwards and uses a single subtraction logic.
     *
     * @param s The Roman numeral string.
     * @return The integer value represented by the Roman numeral.
     */
    fun romanToInt2(s: String): Int {
        var sum = 0
        var previousValue = 0

        for (c in s.toCharArray().reversed()) { // Iterate characters in reverse order
            val value = c.romanCharToInt()
            if (value < previousValue) {
                sum -= value
            } else {
                sum += value
            }
            previousValue = value
        }

        return sum
    }

    private fun Char.romanCharToInt() = when (this) { // Extension function for clarity
        'I' -> 1
        'V' -> 5
        'X' -> 10
        'L' -> 50
        'C' -> 100
        'D' -> 500
        'M' -> 1000
        else -> 0
    }
}