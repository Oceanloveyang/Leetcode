// Given a string array words, find the maximum value of length(word[i]) * length(word[j]) where the two words do not share common letters. You may assume that each word will contain only lower case letters. If no such two words exist, return 0.
//
// Example 1:
//
//
// Input: ["abcw","baz","foo","bar","xtfn","abcdef"]
// Output: 16 
// Explanation: The two words can be "abcw", "xtfn".
//
// Example 2:
//
//
// Input: ["a","ab","abc","d","cd","bcd","abcd"]
// Output: 4 
// Explanation: The two words can be "ab", "cd".
//
// Example 3:
//
//
// Input: ["a","aa","aaa","aaaa"]
// Output: 0 
// Explanation: No such pair of words.
//


public class Solution {
    public int maxProduct(String[] words) {
                int n = words.length;
        int[] elements = new int[n];
        for (int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((elements[i] & elements[j]) == 0)
                    ans = Math.max(ans,words[i].length() * words[j].length());
            }
        }
        return ans;
    }
}
