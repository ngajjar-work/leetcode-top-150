package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/***
 * 242. Valid Anagram
 * https://leetcode.com/problems/valid-anagram/description
 */
class ValidAnagram {

    fun isAnagram(s: String, t: String): Boolean {

        if (s.length != t.length) {
            return false
        }

        val letterCount = IntArray(26)

        for (i in s.indices) {
            letterCount[s[i] - 'a']++
            letterCount[t[i] - 'a']--
        }

        for (count in letterCount) {
            if (count != 0) {
                return false
            }
        }

        return true

    }

    fun isAnagram2(s: String, t: String): Boolean {

        if (s.length != t.length) {
            return false
        }

        val charCountMap = hashMapOf<Char, Int>()

        for (char in s) {
            charCountMap[char] = (charCountMap[char] ?: 0) + 1
        }

        for (char in t) {
            charCountMap[char] = (charCountMap[char] ?: 0) - 1

            if ((charCountMap[char] ?: 0) < 0) return false
        }

        return true

    }

}

class ValidAnagramTest {

    private val uat = ValidAnagram()

    @Test
    fun testInput() {

        Assertions.assertEquals(true, uat.isAnagram("anagram", "nagaram"))
    }

    @Test
    fun testInput1() {

        Assertions.assertEquals(false, uat.isAnagram("rat", "cat"))
    }

    @Test
    fun testInput2() {

        Assertions.assertEquals(false, uat.isAnagram("a", "b"))
    }

}