// Given a string, find the length of the longest substring without repeating characters.
//
// Examples:
//
// Given "abcabcbb", the answer is "abc", which the length is 3.
//
// Given "bbbbb", the answer is "b", with the length of 1.
//
// Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
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
