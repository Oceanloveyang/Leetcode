// Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
//
// Example 1:
//
//
//
// Input: 2
// Output: 1
// Explanation: 2 = 1 + 1, 1 × 1 = 1.
//
//
// Example 2:
//
//
// Input: 10
// Output: 36
// Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
//
// Note: You may assume that n is not less than 2 and not larger than 58.
//
//


class Solution {
public int integerBreak(int n) {
       int[] dp = new int[n + 1];
       dp[1] = 1;
       dp[2] = 1;
    if(n==3){
       dp[3] = 2;
    }
    if(n>3){
        dp[2] = 2;
        dp[3] = 3;
       for(int i = 4; i <= n; i ++) {
           for(int j = 1; j <= i/2; j ++) {
               dp[i] = Math.max(dp[i], dp[j] * dp[i - j]);
           }
       }
    }
       return dp[n];
}
}
