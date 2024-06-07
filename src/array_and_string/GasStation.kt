package array_and_string

/***
 * 134. Gas Station
 * https://leetcode.com/problems/gas-station
 */

class GasStation {


    fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {

        // Starting position in the circular journey
        var start = 0

        // Tracks the current gas balance
        var tankBalance = 0

        // Tracks the total deficit encountered so far
        var totalDeficit = 0

        // Loop through each gas station
        for (i in gas.indices) {

            val gasAtStation = gas[i]
            val costToNext = cost[i]

            // Add gas amount at current station
            tankBalance += gasAtStation - costToNext

            // Check if current balance is negative, indicating insufficient gas
            if (tankBalance < 0) {
                // Update total deficit
                totalDeficit += tankBalance

                // Reset tank balance and starting position for next attempt
                tankBalance = 0
                start = i + 1
            }
        }

        // Add final tank balance to total (might be positive)
        totalDeficit += tankBalance

        // Check if total deficit is negative, indicating no starting point
        // can lead to a complete circuit
        return if (totalDeficit < 0) -1 else start
    }
}