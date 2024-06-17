package com.ngajjarwork.designpatterns.daily_steak

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.pow
import kotlin.math.sqrt

class SumOfSquareNumbers {

    fun judgeSquareSum(c: Int): Boolean {

        val approxCompositeNumber = Math.round(sqrt(c.toDouble()))
        var left = 1
        var right = approxCompositeNumber

        while (left < right) {
            val sum = left.toDouble().pow(2) + right.toDouble().pow(2)
            if (sum.toInt() == c) {
                return true
            } else if (sum.toInt() > c) {
                right--
            } else if (sum.toInt() < c) {
                left++
            }
        }
        return false

    }

}

class SumOfSquareNumbersTest {

    private val uat = SumOfSquareNumbers()

    @Test
    fun testInput1() {
        val expected = true
        val output = uat.judgeSquareSum(29)
        Assertions.assertEquals(expected, output)
    }

    @Test
    fun testInput2() {
        val expected = true
        val output = uat.judgeSquareSum(5)
        Assertions.assertEquals(expected, output)
    }

}