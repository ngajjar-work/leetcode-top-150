package com.ngajjarwork.designpatterns.hashmap

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

/**
 * 49. Group Anagrams
 * https://leetcode.com/problems/group-anagrams/description
 */
class GroupAnagrams {

    fun groupAnagrams(strs: Array<String>): List<List<String>> {

        // Return an empty list if the input array is empty
        if (strs.isEmpty())
            return emptyList()

        // Initialize a HashMap to store groups of anagrams
        val map = HashMap<String, ArrayList<String>>()

        // Iterate over each string in the input array
        for (str in strs) {

            // Generate the frequency string for the current string
            val freqStr = getFrequencyStrings(str)

            // Retrieve the list of anagrams for the frequency string, if it exists
            val mappedString = map[freqStr]
            if (mappedString == null) {
                // If the list does not exist, create a new list and add the current string
                map[freqStr] = arrayListOf(str)
            } else {
                // If the list exists, add the current string to the list
                mappedString.add(str)
            }
        }

        // Convert the values of the map to a list and sort each group of anagrams
        return map.values.map { it.sorted() }
    }

    private fun getFrequencyStrings(str: String): String {
        // Initialize an array to count the frequency of each letter
        val letterCount = IntArray(26)

        // Count the frequency of each letter in the string
        for (i in str.indices) {
            letterCount[str[i] - 'a']++
        }

        // Build the frequency string
        val frequencyBuilder = StringBuilder()

        // Append each letter and its frequency to the frequency string
        for (i in letterCount.indices) {
            if (letterCount[i] > 0) {
                frequencyBuilder.append('a' + i)
                frequencyBuilder.append(letterCount[i])
            }
        }

        // Return the frequency string
        return frequencyBuilder.toString()
    }


    fun groupAnagrams2(strs: Array<String>): List<List<String>> {


        val map = hashMapOf<String, ArrayList<String>>()
        val mappedStringsIndex = mutableSetOf<Int>()
        val list = arrayListOf<List<String>>()

        var index = 0
        var nextIndex = 1

        while (index < strs.size) {

            if (mappedStringsIndex.contains(index)) {
                index++
                nextIndex = index + 1
                continue
            } else if (mappedStringsIndex.contains(nextIndex)) {
                nextIndex++
            } else if (nextIndex < strs.size) {
                val left = strs[index]
                val right = strs[nextIndex]
                val isAnagramsString = isAnagramsString(left, right)

                if (isAnagramsString) {
                    val groupAnagrams = map[left] ?: arrayListOf()
                    groupAnagrams.add(right)
                    map[left] = groupAnagrams
                    mappedStringsIndex.add(nextIndex)
                }

                nextIndex++
            }

            if (nextIndex == strs.size) {
                val mutableList = arrayListOf(strs[index])
                map[strs[index]]?.let {
                    mutableList.addAll(it)
                }
                mutableList.sort()
                list.add(0, mutableList)

                index++
                nextIndex = index + 1
            }
        }

        return list
    }

    private fun isAnagramsString(left: String, right: String): Boolean {
        if (left.length != right.length) {
            return false
        }

        val letterCount = IntArray(26)

        for (i in left.indices) {
            letterCount[left[i] - 'a']++
            letterCount[right[i] - 'a']--
        }

        for (count in letterCount) {
            if (count != 0) {
                return false
            }
        }

        return true
    }
}

class GroupAnagramsTest {

    private val uat = GroupAnagrams()

    @Test
    fun testInput() {

        val expectedOutput = listOf(
            listOf("bat"),
            listOf("nat", "tan"),
            listOf("ate", "eat", "tea"),
        )
        val output = uat.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat"))

        assertEquals(expectedOutput.flatten(), output.flatten())
    }


}