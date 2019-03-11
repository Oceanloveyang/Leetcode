// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
//
// Example 1:
//
//
// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
//
//
// Example 2:
//
//
// Input: "cbbd"
// Output: "bb"
//
//


public class Solution {
    public String longestPalindrome(String s) {
        		  if(s.isEmpty()) return null;
	        if(s.length() == 1) return s;
	        String longest = s.substring(0,1);
	        for(int i=0;i<s.length();++i){
	            // 这里考虑的是回文长度是奇数的情况
	            String tmp = longestPalindromeCenter(s,i,i);
	            if(tmp.length() > longest.length())
	                longest = tmp;
	            //偶数时候
	            if(i<s.length() -1  &&  s.charAt(i)==s.charAt(i+1) ){
	                tmp = longestPalindromeCenter(s,i,i+1);
	                if(tmp.length() > longest.length())
	                    longest = tmp;
	            }
	        }
	        return longest;
    }
     public String longestPalindromeCenter(String s,int left,int right){
	        while(left>=0 && right< s.length() && s.charAt(left)== s.charAt(right)){
	            left--;
	            right++;
	        }// 以s[i] 为中心向两侧扩展，直到不满足回文的条件结束
	        return s.substring(left+1,right);// 结束的时候已经执行了left--  right++ 要去掉
	    }
}
