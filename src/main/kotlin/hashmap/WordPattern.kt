package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/***
 * 290. Word Pattern
 * https://leetcode.com/problems/word-pattern/description
 */
class WordPattern {

    fun wordPattern(pattern: String, s: String): Boolean {

        val wordList = s.trim().split(" ")
        val hashMap = hashMapOf<String, Char>()

        if (wordList.size != pattern.length)
            return false

        wordList.forEachIndexed { index, str ->
            val trimmedStr = str.trim()

            if (hashMap[trimmedStr] == null) {

                if (hashMap.containsValue(pattern[index])) {
                    return false
                }
                hashMap[trimmedStr] = pattern[index]

            } else if (hashMap[trimmedStr] != pattern[index]) {
                return false
            }
        }

        return true
    }
}

class WordPatternTest {

    private val uat = WordPattern()

    @Test
    fun testInput() {
        Assertions.assertEquals(true, uat.wordPattern("abba", "dog cat cat dog"))
    }

    @Test
    fun testInput2() {
        Assertions.assertEquals(false, uat.wordPattern("abba", "dog cat cat fish"))
    }

    @Test
    fun testInput3() {
        Assertions.assertEquals(false, uat.wordPattern("aaaa", "dog cat cat dog"))
    }

}

