package com.ngajjarwork.designpatterns.matrix

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


/**
 * 73. Set Matrix Zeroes
 * https://leetcode.com/problems/set-matrix-zeroes/
 */
class SetMatrixZeroes {


    fun setZeroes(matrix: Array<IntArray>): Unit {
        var isFirstRowZero = false
        var isFirstColumnZero = false

        // Determine if first row or first column needs to be zeroed
        for (rowIndex in 0..matrix.lastIndex) {
            for (columnIndex in 0..matrix[0].lastIndex) {
                if (matrix[rowIndex][columnIndex] == 0) {
                    if (rowIndex == 0) isFirstRowZero = true
                    if (columnIndex == 0) isFirstColumnZero = true
                    matrix[0][columnIndex] = 0
                    matrix[rowIndex][0] = 0
                }
            }
        }

        // Replace inner matrix elements based on the first row and column markers
        for (rowIndex in 1..matrix.lastIndex) {
            for (columnIndex in 1..matrix[0].lastIndex) {
                if (matrix[rowIndex][0] == 0 || matrix[0][columnIndex] == 0) {
                    matrix[rowIndex][columnIndex] = 0
                }
            }
        }

        // Check and set first row if needed
        if (isFirstRowZero) {
            for (columnIndex in 0..matrix[0].lastIndex) {
                matrix[0][columnIndex] = 0
            }
        }

        // Check and set first column if needed
        if (isFirstColumnZero) {
            for (rowIndex in 0..matrix.lastIndex) {
                matrix[rowIndex][0] = 0
            }
        }
    }
}

class SetMatrixZeroesTest {

    private val uat = SetMatrixZeroes()

    @Test
    fun testInput() {

        val input = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1)
        )

        val expectedOutput = arrayOf(
            intArrayOf(1, 0, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(1, 0, 1)
        )

        uat.setZeroes(input)


        Assertions.assertArrayEquals(expectedOutput, input) {
            "Matrix did not rotate correctly"
        }
    }

}