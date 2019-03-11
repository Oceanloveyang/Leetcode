// Implement a basic calculator to evaluate a simple expression string.
//
// The expression string may contain open ( and closing parentheses ), the plus + or minus sign -, non-negative integers and empty spaces  .
//
// Example 1:
//
//
// Input: "1 + 1"
// Output: 2
//
//
// Example 2:
//
//
// Input: " 2-1 + 2 "
// Output: 3
//
// Example 3:
//
//
// Input: "(1+(4+5+2)-3)+(6+8)"
// Output: 23
// Note:
//
//
// 	You may assume that the given expression is always valid.
// 	Do not use the eval built-in library function.
//
//


class Solution {
    public int calculate(String s) {
        int length = s.length();
        int flag =1;
        int res = 0;
        Stack<Integer> stack = new Stack();
        for(int i=0;i<length;i++ ){
            if(Character.isDigit(s.charAt(i))){
                int sum = s.charAt(i)-'0';
                while(i+1<length&&Character.isDigit(s.charAt(i+1))){
                    sum = sum*10+s.charAt(i+1)-'0';
                    i++;
                }
                res += sum*flag;
            }else if(s.charAt(i)=='+'){
                flag=1;
            }else if(s.charAt(i)=='-'){
                flag=-1;
            }else if(s.charAt(i)=='('){
                stack.push(res);
                stack.push(flag);
                res = 0;
                flag =1;
            }else if(s.charAt(i)==')'){
                res =res*stack.pop()+stack.pop();
            }
        }
        return res;
    }
}
