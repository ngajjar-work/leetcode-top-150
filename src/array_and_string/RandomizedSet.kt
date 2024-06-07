package array_and_string

import java.util.*
import kotlin.random.Random

/***
 * 380. Insert Delete GetRandom O(1)
 * https://leetcode.com.problems/insert-delete-getrandom-o1/description
 */
class RandomizedSet {

    /**
     * Internal vector to store the elements.
     */
    private val mVector = Vector<Int>()

    /**
     * HashMap to store the index of each element in the vector for constant time lookup.
     * Key: The element value.
     * Value: The index of the element in the vector.
     */
    private val mMap = HashMap<Int, Int>()


    /**
     * Inserts an element into the data structure if it's not already present.
     * Time complexity: O(1) due to constant time lookups in the HashMap.
     *
     * @param `val`: The element to insert.
     * @return `true` if the element was inserted successfully, `false` otherwise.
     */
    fun insert(`val`: Int): Boolean {
        if (mMap.containsKey(`val`)) {  // Check if element already exists
            return false
        }
        mVector.add(`val`)  // Add element to the vector
        mMap[`val`] = mVector.size - 1  // Store element's index in the map

        return true
    }

    /**
     * Removes an element from the data structure if it's present.
     * Time complexity: O(1) due to constant time lookups and updates in the HashMap.
     *
     * @param `val`: The element to remove.
     * @return `true` if the element was removed successfully, `false` otherwise.
     */
    fun remove(`val`: Int): Boolean {
        val index = mMap[`val`]  // Get the element's index from the map
        return index?.let {  // Check if element exists
            val lastElement = mVector.last()  // Get the last element in the vector
            mVector[it] = lastElement  // Swap the element to be removed with the last element
            mMap[lastElement] = it  // Update the last element's index in the map
            mVector.removeAt(mVector.size - 1)  // Remove the last element from the vector
            mMap.remove(`val`)  // Remove the element from the map

            true
        } ?: false
    }

    /**
     * Returns a random element from the data structure.
     * Time complexity: O(1) because accessing a random element in the vector is constant time.
     *
     * @return A random element from the data structure.
     */
    fun getRandom(): Int {
        val randomIndex = Random.nextInt(mVector.size)  // Generate a random index within the vector size
        return mVector[randomIndex]  // Return the element at the random index
    }
}