package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

/***
 * 205. Isomorphic Strings
 * https://leetcode.com/problems/isomorphic-strings/description
 */

class IsomorphicStrings {

    fun isIsomorphic(s: String, t: String): Boolean {

        if (s.length != t.length)
            return false

        val map = hashMapOf<Char, Char>()

        s.forEachIndexed { index, c ->

            if (map[c] == null) {

                if (map.containsValue(t[index])) {
                    return false
                }
                map[c] = t[index]

            } else if (map[c] != t[index]) {
                return false
            }
        }
        return true
    }


}

class IsomorphicStringsTest {

    val uat = IsomorphicStrings()

    @Test
    fun testInput() {
        Assertions.assertEquals(false, uat.isIsomorphic("badc", "baba"))
    }

    @Test
    fun testInput1() {
        Assertions.assertEquals(true, uat.isIsomorphic("egg", "add"))
    }

    @Test
    fun testInput2() {
        Assertions.assertEquals(false, uat.isIsomorphic("foo", "bar"))
    }

}