// Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
// An input string is valid if:
//
//
// 	Open brackets must be closed by the same type of brackets.
// 	Open brackets must be closed in the correct order.
//
//
// Note that an empty string is also considered valid.
//
// Example 1:
//
//
// Input: "()"
// Output: true
//
//
// Example 2:
//
//
// Input: "()[]{}"
// Output: true
//
//
// Example 3:
//
//
// Input: "(]"
// Output: false
//
//
// Example 4:
//
//
// Input: "([)]"
// Output: false
//
//
// Example 5:
//
//
// Input: "{[]}"
// Output: true
//
//


class Solution {
    public boolean isValid(String s) {
        if(s.length()==0){
            return true;
        }
        if(s.length()%2!=0){
            return false;
        }else{
            Stack<Character> stack = new Stack<>();
            int length = s.length();
            char[] pare = s.toCharArray();
            stack.push(pare[0]);
            for(int i=1;i<length;i++){
                if((pare[i]=='}'&&stack.peek()=='{')||(pare[i]==')'&&stack.peek()=='(')||(pare[i]==']'&&stack.peek()=='[')){
                    stack.pop();
                }else{
                    stack.push(pare[i]);
                }
            }
            return stack.size()==0;
        }
    }
}
