package com.ngajjarwork.designpatterns.matrix

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 48. Rotate Image
 * https://leetcode.com/problems/rotate-image/description
 */

class RotateImage {

    fun rotate(matrix: Array<IntArray>) {

        val n = matrix.size

        // Transpose the matrix
        for (i in 0 until n) {
            for (j in i until n) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[j][i]
                matrix[j][i] = temp
            }
        }

        // Reverse each row
        for (i in 0 until n) {
            for (j in 0 until n / 2) {
                val temp = matrix[i][j]
                matrix[i][j] = matrix[i][n - 1 - j]
                matrix[i][n - 1 - j] = temp
            }
        }
    }

    fun rotate2(matrix: Array<IntArray>) {

        val n = matrix.size

        //cycle of matrix
        for (i in 0..<(n + 1) / 2) {


            //elements of cycles
            for (j in i..n / 2) {


                //top left -> temp
                val temp = matrix[i][j]


                //bottom left -> top left
                matrix[i][j] = matrix[n - 1 - j][i]


                //bottom right -> bottom left
                matrix[n - 1 - j][i] = matrix[n - 1 - i][n - 1 - j]


                //top right to bottom right
                matrix[n - 1 - i][n - 1 - j] = matrix[j][n - 1 - i]


                //temp -> top right
                matrix[j][n - 1 - i] = temp
            }

        }
    }
}

class RotateImageTest {

    private val rotateImage = RotateImage()

    @Test
    fun testInput() {

        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9)
        )

        val expectedOutput = arrayOf(
            intArrayOf(7, 4, 1),
            intArrayOf(8, 5, 2),
            intArrayOf(9, 6, 3)
        )

        rotateImage.rotate(matrix)

        Assertions.assertArrayEquals(expectedOutput, matrix) { "Matrix did not rotate correctly" }
    }
}