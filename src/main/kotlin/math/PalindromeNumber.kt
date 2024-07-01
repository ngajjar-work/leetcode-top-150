package com.ngajjarwork.designpatterns.math

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 9. Palindrome Number
 * https://leetcode.com/problems/palindrome-number
 */
class PalindromeNumber {

    fun isPalindrome(x: Int): Boolean {
        // Negative numbers are not palindromes
        if (x < 0) return false

        // Create a reversed version of the number
        var original = x
        var reversed = 0

        while (original != 0) {
            val digit = original % 10
            reversed = reversed * 10 + digit
            original /= 10
        }

        // Check if the reversed number is equal to the original number
        return x == reversed
    }
}

class PalindromeNumberTest {

    private val uat = PalindromeNumber()

    @Test
    fun testInput1() {
        Assertions.assertTrue(uat.isPalindrome(121))
    }

    @Test
    fun testInput2() {
        Assertions.assertFalse(uat.isPalindrome(-121))
    }

    @Test
    fun testInput3() {
        Assertions.assertFalse(uat.isPalindrome(10))
    }

}
