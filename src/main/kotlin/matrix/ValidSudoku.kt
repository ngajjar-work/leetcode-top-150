package com.ngajjarwork.designpatterns.matrix

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/***
 * 36. Valid Sudoku
 * https://leetcode.com/problems/valid-sudoku/description
 */

class ValidSudoku {


    /**
     * This function validates if the given `board` represents a valid Sudoku solution.
     * A valid Sudoku board meets the following criteria:
     *  - Each row must contain the digits 1-9 without repetition.
     *  - Each column must contain the digits 1-9 without repetition.
     *  - Each of the nine 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
     *
     * This solution uses separate arrays (`rows`, `columns`, `subBoxes`) to store
     * the digits encountered in each row, column, and sub-box respectively.
     * It iterates through the board and checks if adding a digit to the corresponding
     * sets in these arrays fails. If adding fails (meaning the digit already exists),
     * it indicates a duplicate and the function returns false.
     *
     * @param board: A 2D character array representing the Sudoku board.
     * @return: True if the board is a valid Sudoku solution, false otherwise.
     */
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val rows = Array(9) { HashSet<Int>() }  // Stores digits in each row
        val columns = Array(9) { HashSet<Int>() }  // Stores digits in each column
        val subBoxes = Array(9) { HashSet<Int>() }  // Stores digits in each sub-box

        for (rowIndex in 0..board.lastIndex) {  // Iterate through rows

            for (columnIndex in 0..board[rowIndex].lastIndex) {  // Iterate through elements in each row

                if (board[rowIndex][columnIndex].isDigit()) {  // Check if digit

                    val element = board[rowIndex][columnIndex].digitToInt()  // Convert digit to int
                    val subMatrixIndex = (rowIndex / 3) * 3 + columnIndex / 3  // Calculate sub-box index

                    // Check if digit already exists in row, column, or sub-box
                    if (!rows[rowIndex].add(element) ||
                        !columns[columnIndex].add(element) ||
                        !subBoxes[subMatrixIndex].add(element)
                    ) {
                        return false  // Duplicate digit found, board is invalid
                    }

                }
            }
            rows[rowIndex].clear()  // Clear row set for next iteration
        }

        return true  // No duplicates found, board is valid
    }

    fun isValidSudoku2(board: Array<CharArray>): Boolean {

        val hashMap = mutableMapOf<String, HashSet<Int>>()

        //check rows
        for (rowIndex in 0..board.lastIndex) {

            for (columnIndex in 0..board[rowIndex].lastIndex) {

                if (board[rowIndex][columnIndex].isDigit()) {
                    val element = board[rowIndex][columnIndex].digitToInt()

                    //check column elements
                    val columnList = hashMap["column_$columnIndex"] ?: hashSetOf()
                    if (!columnList.add(element)) {
                        return false
                    } else {
                        hashMap["column_$columnIndex"] = columnList
                    }

                    //check row elements
                    val rowList = hashMap["row_$rowIndex"] ?: hashSetOf()
                    if (!rowList.add(element)) {
                        return false
                    } else {
                        hashMap["row_$rowIndex"] = rowList
                    }

                    //check subBox
                    val subBoxRow = (rowIndex) / 3
                    val subBoxColumn = (columnIndex) / 3
                    val subBoxKey = String.format("sub_box_%d_%d", subBoxRow, subBoxColumn)

                    //check column element
                    val subBoxList = hashMap[subBoxKey] ?: hashSetOf()
                    if (!subBoxList.add(element)) {
                        return false
                    } else {
                        hashMap[subBoxKey] = subBoxList
                    }
                }
            }
        }

        return true
    }

}


class ValidSudokuTest {

    val uat = ValidSudoku()


    @Test
    fun testInput1() {

        //arrange
        val board = arrayOf(
            charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
            charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
            charArrayOf('.', '9', '2', '.', '.', '.', '.', '6', '.'),
            charArrayOf('1', '.', '.', '.', '6', '.', '.', '.', '3'),
            charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
            charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
            charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
            charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
            charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
        )
        val expected = true

        //act
        val output = uat.isValidSudoku(board)

        //assert
        Assertions.assertEquals(expected, output)

    }
}