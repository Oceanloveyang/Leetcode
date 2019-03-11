// Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and a non-negative integer fee representing a transaction fee.
// You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.  You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
// Return the maximum profit you can make.
//
// Example 1:
//
// Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
// Output: 8
// Explanation: The maximum profit can be achieved by:
// Buying at prices[0] = 1Selling at prices[3] = 8Buying at prices[4] = 4Selling at prices[5] = 9The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
//
//
//
// Note:
// 0 < prices.length <= 50000.
// 0 < prices[i] < 50000.
// 0 <= fee < 50000.
//


class Solution {
    public int maxProfit(int[] prices, int fee) {
        int length = prices.length;
        int[] buy = new int[length];
        int[] sell = new int[length];
        buy[0]=-prices[0];
        // buy[1]=prices[1]-prices[0]>0?-prices[0]:-prices[1];
        sell[0]=0;
        // sell[1]=prices[1]-
        for(int i=1;i<length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-1]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]-fee);
        }
        return sell[length-1];
    }
}
