package array_and_string

/***
 *  14. Longest Common Prefix
 *  https://leetcode.com/problems/longest-common-prefix
 */
class LongestCommonPrefix {

    fun longestCommonPrefix(strs: Array<String>): String {


        if (strs.size == 1) {
            return strs[0]
        }

        var stringsIndex = 1
        var commonString = strs[0]

        while (stringsIndex < strs.size) {
            var mCommonString = ""
            for (index in 0..commonString.lastIndex) {
                if (index < strs[stringsIndex].length && strs[stringsIndex][index] == commonString[index]) {
                    mCommonString += commonString[index]
                } else {
                    break
                }
            }
            stringsIndex++

            if (mCommonString.isEmpty()) {
                return ""
            } else {
                commonString = mCommonString
            }
        }
        return commonString
    }

}