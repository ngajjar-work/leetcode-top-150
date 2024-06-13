package array_and_string


/***
 * 6. Zigzag Conversion
 * https://leetcode.com/problems/zigzag-conversion/
 */
class ZigzagConversion {

    /**
     * This function converts a string (`s`) into a zigzag pattern based on the
     * number of rows (`numRows`).
     *
     * Steps:
     * 1. Create an array of StringBuilder objects with a size equal to the minimum
     *    of `numRows` and the string length (`s.length`). Each StringBuilder will
     *    hold the characters for a specific row in the zigzag pattern.
     * 2. Initialize variables:
     *    - `rowIndex`: Keeps track of the current row index (starts at 0).
     *    - `isGoingDown`: A flag indicating if we're appending characters in a
     *      downward or upward direction.
     * 3. Iterate through each character (`c`) in the string:
     *    - Append the character `c` to the StringBuilder of the current row (`rowString[rowIndex]`).
     *    - If we're at the first or last row, change the direction flag (`isGoingDown`).
     *    - Update the `rowIndex` based on the direction flag:
     *        - If going down, increment by 1.
     *        - If going up, decrement by 1.
     * 4. Join all the StringBuilders in the `rowString` array into a single string
     *    and return it.
     *
     * @param s: The input string.
     * @param numRows: The number of rows in the zigzag pattern.
     * @return: The converted string in a zigzag pattern.
     */
    fun convert(s: String, numRows: Int): String {

        val rowString = Array(minOf(numRows, s.length)) { StringBuilder() }

        var rowIndex = 0
        var isGoingDown = false

        for (c in s) {
            rowString[rowIndex].append(c)
            if (rowIndex == 0 || rowIndex == rowString.lastIndex) {
                isGoingDown = !isGoingDown
            }
            rowIndex = if (isGoingDown) rowIndex + 1 else rowIndex - 1
        }

        return rowString.joinToString("")
    }
}