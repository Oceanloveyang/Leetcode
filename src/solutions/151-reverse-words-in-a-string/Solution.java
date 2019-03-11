// Given an input string, reverse the string word by word.
//
//  
//
// Example 1:
//
//
// Input: "the sky is blue"
// Output: "blue is sky the"
//
//
// Example 2:
//
//
// Input: "  hello world!  "
// Output: "world! hello"
// Explanation: Your reversed string should not contain leading or trailing spaces.
//
//
// Example 3:
//
//
// Input: "a good   example"
// Output: "example good a"
// Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//
//  
//
// Note:
//
//
// 	A word is defined as a sequence of non-space characters.
// 	Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
// 	You need to reduce multiple spaces between two words to a single space in the reversed string.
//
//
//  
//
// Follow up:
//
// For C programmers, try to solve it in-place in O(1) extra space.


public class Solution {
    public String reverseWords(String s) {
    String[] str = s.split(" ");
    if (str == null || str.length == 0) {
        return s.trim();
    }

    if (str.length == 1) {
        return s.trim();
    }
    Stack<String> stack = new Stack<String>();
    for (int i = 0; i < str.length; i++) {
        if (str[i].trim().equals("")) {
            continue;
        }
        stack.push(str[i]);
    }
    if (null == stack || stack.size() == 0) {
        return s;
    }
    StringBuilder sb = new StringBuilder();
    int length = stack.size();
    for (int i = 0; i < length; i++) {
        String a = stack.pop();
        if(i!=length-1){
        sb.append(a).append(" ");
        }else{
            sb.append(a);
        }
    }
    return sb.toString();
    }
}
