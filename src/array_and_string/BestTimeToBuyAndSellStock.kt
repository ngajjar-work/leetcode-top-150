package array_and_string

import kotlin.math.max

/***
 * 121. Best Time to Buy and Sell Stock
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description
 */
class BestTimeToBuyAndSellStock {

    /**
     * Finds the maximum profit that can be obtained by buying and selling a stock once.
     * This approach iterates through the prices array and keeps track of the minimum price seen so far and the maximum profit.
     * It updates the maximum profit whenever the difference between the current price and the minimum price is greater than the current maximum profit.
     *
     * @param prices The array of stock prices.
     * @return The maximum profit achievable by buying and selling the stock once.
     */
    fun maxProfit(prices: IntArray): Int {
        if (prices.isEmpty()) return 0  // Handle empty array case

        var minPrice = Int.MAX_VALUE  // Initialize minimum price to positive infinity
        var maxProfit = 0  // Initialize maximum profit to 0

        for (price in prices) {
            if (price < minPrice) {  // Update minimum price if a lower price is encountered
                minPrice = price
            } else if (price - minPrice > maxProfit) {  // Update maximum profit if current profit is higher
                maxProfit = price - minPrice
            }
        }

        return maxProfit
    }

    /**
     * Finds the maximum profit that can be obtained by buying and selling a stock once (alternative approach).
     * This approach iterates through the prices array and keeps track of the lowest buying price seen so far and the maximum profit.
     * It updates the maximum profit whenever the difference between the current price and the lowest buying price is greater than the current maximum profit.
     *
     * @param prices The array of stock prices.
     * @return The maximum profit achievable by buying and selling the stock once.
     */
    fun maxProfit2(prices: IntArray): Int {
        var lowest = 0  // Index of the lowest buying price seen so far
        var profit = 0  // Maximum profit

        for (i in 1..prices.lastIndex) {  // Start from the second day (can't buy on the first day)
            if (prices[i] < prices[lowest]) {  // Update lowest buying price if a lower price is encountered
                lowest = i
            } else {
                profit = max(profit, prices[i] - prices[lowest])  // Update maximum profit if current profit is higher
            }
        }

        return profit
    }

    /**
     * Finds the maximum profit that can be obtained by buying and selling a stock once (alternative approach - start from selling day).
     * This approach starts from the last day (selling day) and iterates backwards.
     * It compares the current price with the price on the previous day (potential buying day) and updates the maximum profit if necessary.
     *
     * @param prices The array of stock prices.
     * @return The maximum profit achievable by buying and selling the stock once.
     */
    fun maxProfit3(prices: IntArray): Int {

        var sellingIndex = prices.lastIndex  // Start from the last day (selling day)
        var buyingIndex = sellingIndex - 1  // Initialize potential buying day as the day before selling

        var profit = 0  // Maximum profit

        while (sellingIndex > 0 && buyingIndex >= 0) {  // Loop until both indexes reach the beginning

            // Check if we can get maximum profit by selling on the current day
            if (prices[sellingIndex] > prices[buyingIndex] && prices[sellingIndex] - prices[buyingIndex] > profit) {
                profit = prices[sellingIndex] - prices[buyingIndex]  // Update maximum profit
            }

            // Reset selling and buying indexes for the next iteration
            if (buyingIndex == 0) {  // If buying index reaches the beginning, move selling index to the previous day
                sellingIndex--
                buyingIndex = sellingIndex - 1
            } else {  // Otherwise, just decrement the buying index
                buyingIndex--
            }
        }

        return profit
    }
}