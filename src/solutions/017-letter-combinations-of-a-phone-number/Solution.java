// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
//
// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
//
//
//
// Example:
//
//
// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
//
//
// Note:
//
// Although the above answer is in lexicographical order, your answer could be in any order you want.
//


class Solution {
    static String[] stringMap = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> letter = new ArrayList<>();
        if(digits.equals("")){
            return letter;
        }
        dfs(letter, 0, "", digits);
        return letter;
    }
    
    public void dfs(List<String> letter, int index, String str, String digits){
         if(index == digits.length()){
             letter.add(str);
             return;
         }   
        if(digits.charAt(index)=='1'){
            dfs(letter, index+1, str, digits);
        }else{
            String tmp=stringMap[Integer.parseInt(digits.substring(index,index+1))-2];
            for(int i = 0;i<tmp.length();i++){
                dfs(letter,index+1,str+tmp.substring(i,i+1),digits);
            }
        }
    }
}
