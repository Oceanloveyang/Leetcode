// Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
//
// Example 1:
//
//
// Input: "(()"
// Output: 2
// Explanation: The longest valid parentheses substring is "()"
//
//
// Example 2:
//
//
// Input: ")()())"
// Output: 4
// Explanation: The longest valid parentheses substring is "()()"
//
//


class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        char[] tmp = s.toCharArray();
        int[] dp = new int[length];
        int max = 0;
        for(int i=1;i<length;i++){
            if(tmp[i]==')'&&tmp[i-1]=='('){
                dp[i]=(i-2>=0?dp[i-2]:0)+2;
            }else if(tmp[i]==')'&&tmp[i-1]==')'&&i-1-dp[i-1]>=0){
                if(tmp[i-1-dp[i-1]]=='(') {
                    dp[i]=(i-2-dp[i-1]>=0?dp[i-dp[i-1]-2]+dp[i-1]+2:dp[i-1]+2);
                }
            }
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}


