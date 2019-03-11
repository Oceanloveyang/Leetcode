// Given a string, find the length of the longest substring without repeating characters.
//
//
// Example 1:
//
//
// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 
//
//
//
// Example 2:
//
//
// Input: "bbbbb"
// Output: 1
// Explanation: The answer is "b", with the length of 1.
//
//
//
// Example 3:
//
//
// Input: "pwwkew"
// Output: 3
// Explanation: The answer is "wke", with the length of 3. 
//              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
//
//
//
//


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        		 if(s==null || s.length()==0)
		  return 0;
		int max=0;
		int start=0;
		int i=0;
		HashSet<Character> set=new HashSet<Character>();
		while(i<s.length()){
			char c=s.charAt(i);
			if(!set.contains(c)){
				set.add(c);
			}
			else{
				max=Math.max(max,set.size());
			    while(start<i&&s.charAt(start)!=c){
				    set.remove(s.charAt(start));
				    start++;
			    }
			    start++;
		    }
			i++;
			//max=Math.max(max,set.size());
	    }
		max=Math.max(max,set.size());
		return max;
    }
}
