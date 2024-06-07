package array_and_string

/**
 * 12. Integer to Roman
 * https://leetcode.com/problems/integer-to-roman
 */
class IntegerToRoman {

    // Predefined Roman numeral combinations in descending order (more efficient for loop)
    private val romanCombinations = arrayOf(
        "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"
    )

    // Corresponding integer values for each Roman numeral combination
    private val intValuesOfRomanCombinations = intArrayOf(
        1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1
    )

    /**
     * Converts an integer to its Roman numeral representation.
     *
     * @param num The integer to be converted.
     * @return The Roman numeral representation of the integer.
     */
    fun intToRoman(num: Int): String {
        var remainingNumber = num  // Use a more descriptive variable name
        val romanNumberBuilder = StringBuilder()
        var currentIndex = 0  // Use a more descriptive variable name

        while (remainingNumber > 0 && currentIndex < romanCombinations.size) {
            val currentRomanValue = intValuesOfRomanCombinations[currentIndex]
            if (remainingNumber >= currentRomanValue) {
                remainingNumber -= currentRomanValue
                romanNumberBuilder.append(romanCombinations[currentIndex])
            } else {
                currentIndex++  // Move to the next Roman numeral combination
            }
        }

        return romanNumberBuilder.toString()
    }
}