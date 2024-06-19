package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/**
 * 383. Ransom Note
 * https://leetcode.com/problems/ransom-note/descriptio
 */
class RansomNote {

    /**
     * Checks if a ransom note can be constructed from a magazine using the available characters.
     *
     * @param ransomNote: The string representing the ransom note.
     * @param magazine: The string representing the magazine containing characters.
     * @return: True if the ransom note can be constructed, False otherwise.
     */
    fun canConstruct(ransomNote: String, magazine: String): Boolean {

        // Check if the ransom note is longer than the magazine,
        // in this case it's impossible to construct the note.
        if (ransomNote.length > magazine.length)
            return false

        // Create a HashMap to store character counts in the magazine.
        val map = hashMapOf<Char, Int>()

        // Iterate through each character in the magazine and update its count in the map.
        for (m in magazine) {
            map[m] = (map[m] ?: 0) + 1  // Use Elvis operator for default value (0) if key not found.
        }

        // Iterate through each character in the ransom note.
        for (r in ransomNote) {

            // Decrement the count of the character in the map (if it exists).
            map[r] = (map[r] ?: 0) - 1  // Use Elvis operator for default value (0) if key not found.

            // Check if the character count becomes negative, indicating insufficient characters in the magazine.
            if (map[r] == -1) {
                return false
            }
        }

        // If the loop completes without finding insufficient characters, return true.
        return true
    }
}


class RansomNoteTest {

    val uat = RansomNote()

    @Test
    fun testInput1() {

        //assert
        Assertions.assertEquals(false, uat.canConstruct("a", "b"))
    }

    @Test
    fun testInput2() {

        //assert
        Assertions.assertEquals(false, uat.canConstruct("aa", "ab"))
    }

    @Test
    fun testInput3() {

        //assert
        Assertions.assertEquals(true, uat.canConstruct("aa", "aab"))
    }
}