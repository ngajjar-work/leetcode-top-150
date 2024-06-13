package array_and_string

/***
 * 122. Best Time to Buy and Sell Stock II
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
class BestTimeToBuyAndSellStock2 {

    /**
     * Finds the maximum profit that can be obtained by buying and selling a stock multiple times.
     * This approach iterates through the prices array and keeps track of the total profit.
     * It adds the profit whenever the current price is higher than the previous price.
     *
     * @param prices The array of stock prices.
     * @return The maximum profit achievable by buying and selling the stock multiple times.
     */
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0  // Initialize maximum profit to 0
        for (index in 1..prices.lastIndex) {
            val profit = prices[index] - prices[index - 1]  // Calculate profit for buying yesterday and selling today
            if (profit > 0) {  // Add profit only if it's positive
                maxProfit += profit
            }
        }
        return maxProfit
    }

    /**
     * Finds the maximum profit that can be obtained by buying and selling a stock multiple times (alternative approach).
     * This approach iterates through the prices array and keeps track of the minimum price seen so far and the total profit.
     * It adds the profit whenever the current price is higher than the minimum price.
     *
     * @param prices The array of stock prices.
     * @return The maximum profit achievable by buying and selling the stock multiple times.
     */
    fun maxProfit2(prices: IntArray): Int {

        var maxProfit = 0  // Initialize maximum profit to 0
        var minValue = prices[0]  // Initialize minimum value to the first price

        for (index in 1..prices.lastIndex) {
            if (prices[index] > prices[index - 1]) {  // Check for increasing price trend
                maxProfit += prices[index] - prices[index - 1]  // Add profit if current price is higher than previous
            } else if (minValue < prices[index]) {  // Update minimum value if a lower price is encountered
                minValue = prices[index]
            }
        }
        return maxProfit
    }
}