// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
//
//
// 	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
// 	After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
//
//
// Example:
//
//
// Input: [1,2,3,0,2]
// Output: 3 
// Explanation: transactions = [buy, sell, cooldown, buy, sell]
//


class Solution {
    public int maxProfit(int[] prices) {
        int length = prices.length;
        int[] buy = new int[length+1];
        int[] sell = new int[length+1];
        if(length==0||length==1){
            return 0;
        }
        buy[0]=-prices[0];
        buy[1]=prices[1]-prices[0]>0?-prices[0]:-prices[1];
        sell[0]=0;
        sell[1]=prices[1]-prices[0]>0?prices[1]-prices[0]:0;
        System.out.println(sell[1]);
        for(int i=2;i<length;i++){
            buy[i]=Math.max(buy[i-1],sell[i-2]-prices[i]);
            sell[i]=Math.max(sell[i-1],buy[i-1]+prices[i]);
            // sell[i+1]=sell[i];
            // buy[i+1]=buy[i];
        }
        // System.out.println(sell[3]);
        return sell[length-1]>0?sell[length-1]:0;
    }
}
