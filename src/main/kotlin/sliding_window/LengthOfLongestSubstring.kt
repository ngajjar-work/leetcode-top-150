package com.ngajjarwork.designpatterns.sliding_window

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import kotlin.math.max

/**
 * 3. Longest Substring Without Repeating Characters
 * https://leetcode.com/problems/longest-substring-without-repeating-characters
 */
class LengthOfLongestSubstring {

    /**
     * This function finds the length of the longest substring in the `s` string
     * that does not contain any repeating characters.
     *
     * Uses a sliding window approach with two pointers (`start` and `end`):
     *  1. Initialize variables:
     *      - `start`: Starting index of the current window.
     *      - `end`: Ending index of the current window (exclusive).
     *      - `charSet`: A mutable set to store characters encountered within the window.
     *      - `maxLen`: Stores the length of the longest substring found so far.
     *  2. Iterate using an `end` pointer from 0 to the end of the string `s`:
     *      - If the current character (`s[end]`) is not present in the `charSet`:
     *          - Add the character to `charSet`.
     *          - Increment `end` to expand the window.
     *          - Update `maxLen` if the current window length (`end - start`) is greater.
     *      - If the current character is already in `charSet`:
     *          - Remove the character at the `start` index from `charSet`.
     *          - Increment `start` to shrink the window from the left.
     *  3. After iterating through the entire string, `maxLen` will hold the length
     *     of the longest substring without repeating characters. Return it.
     *
     * @param s: The input string to search within.
     * @return: The length of the longest substring without repeating characters.
     */
    fun lengthOfLongestSubstring(s: String): Int {

        var start = 0
        var end = 0
        val charSet = mutableSetOf<Char>()
        var maxLen = 0

        while (end < s.length) {
            if (!charSet.contains(s[end])) {
                charSet.add(s[end])
                end++
                maxLen = max(maxLen, end - start)
            } else {
                charSet.remove(s[start])
                start++
            }
        }
        return maxLen
    }
}

class LengthOfLongestSubstringTest {

    private val lengthOfLongestSubstring = LengthOfLongestSubstring()

    @Test
    fun testInput() {
        val input = "abcabcbb"
        val expectedOutput = 3
        val actualOutput = lengthOfLongestSubstring.lengthOfLongestSubstring(input)

        Assertions.assertEquals(expectedOutput, actualOutput)
    }

    @Test
    fun testInput2() {
        val input = "bbbbb"
        val expectedOutput = 1
        val actualOutput = lengthOfLongestSubstring.lengthOfLongestSubstring(input)

        Assertions.assertEquals(expectedOutput, actualOutput)
    }


    @Test
    fun testInput3() {
        val input = "pwwkew"
        val expectedOutput = 3
        val actualOutput = lengthOfLongestSubstring.lengthOfLongestSubstring(input)

        Assertions.assertEquals(expectedOutput, actualOutput)
    }
}

