// Write a function to find the longest common prefix string amongst an array of strings.
//
// If there is no common prefix, return an empty string "".
//
// Example 1:
//
//
// Input: ["flower","flow","flight"]
// Output: "fl"
//
//
// Example 2:
//
//
// Input: ["dog","racecar","car"]
// Output: ""
// Explanation: There is no common prefix among the input strings.
//
//
// Note:
//
// All given inputs are in lowercase letters a-z.
//


class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = "";
        if(strs.length>0){
        int short_length = strs[0].length();
        for(int i=1; i<strs.length;i++)
            short_length = Math.min(short_length,strs[i].length());
        for(int i=0;i<short_length;i++){
            String tmp = strs[0].substring(i,i+1);
            int flag = 0;
            for(int j=1;j<strs.length;j++){
                if(!strs[j].substring(i,i+1).equals(tmp)){
                    break;
                }else{
                    flag = j;
                }
            }
            if(flag==strs.length-1){
                prefix+=tmp;
            }else{
                break;
            }
            
        }
        return prefix;
        
    }
    else{
        return prefix;
    }
    }
}
