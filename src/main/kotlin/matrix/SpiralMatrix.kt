package com.ngajjarwork.designpatterns.matrix

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test


/***
 * 54. Spiral Matrix
 * https://leetcode.com/problems/spiral-matrix
 */
class SpiralMatrix {

    fun spiralOrder(matrix: Array<IntArray>): List<Int> {

        val result = mutableListOf<Int>()

        if (matrix.isEmpty() || matrix[0].isEmpty()) return result

        var top = 0
        var bottom = matrix.size - 1
        var left = 0
        var right = matrix[0].size - 1

        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top boundary
            for (i in left..right) {
                result.add(matrix[top][i])
            }
            top++

            // Traverse from top to bottom along the right boundary
            for (i in top..bottom) {
                result.add(matrix[i][right])
            }
            right--

            // Traverse from right to left along the bottom boundary, if still valid
            if (top <= bottom) {
                for (i in right downTo left) {
                    result.add(matrix[bottom][i])
                }
                bottom--
            }

            // Traverse from bottom to top along the left boundary, if still valid
            if (left <= right) {
                for (i in bottom downTo top) {
                    result.add(matrix[i][left])
                }
                left++
            }
        }

        return result
    }

}

class SpiralMatrixTest {

    private val uat = SpiralMatrix()

    @Test
    fun testInput1() {

        val input = arrayOf(
            intArrayOf(1, 2, 3, 4),
            intArrayOf(5, 6, 7, 8),
            intArrayOf(9, 10, 11, 12)
        )

        val expected = listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7)

        val output = uat.spiralOrder(input)

        Assertions.assertEquals(expected, output)
    }
}