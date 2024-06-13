package array_and_string

/***
 * https://leetcode.com/problems/h-index/description
 * 274. H-Index
 */
class HIndex {

    /**
     * Calculates the H-index of a researcher based on a list of citation counts.
     * The H-index is a measure of a researcher's productivity and impact.
     * An H-index of h means h of the researcher's papers have at least h citations each, and the other n-h papers have no more than h citations each.
     *
     * This approach sorts the citations array in descending order and iterates through it.
     * The H-index is the maximum index where the value at that index is greater than the index itself.
     *
     * @param citations The array of citation counts for each paper.
     * @return The H-index of the researcher.
     */
    fun hIndex(citations: IntArray): Int {
        var index = 0
        val size = citations.size
        citations.sortDescending()  // Sort citations in descending order

        while (index < size && citations[index] > index) {
            index++  // Increment index as long as citations are greater than the index
        }
        return index
    }
}