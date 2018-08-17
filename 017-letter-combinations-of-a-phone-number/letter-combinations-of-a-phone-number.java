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


public class Solution {
    public List<String> letterCombinations(String digits) {
        		LinkedList<String> result=new LinkedList<String>();
		String[] map=new String[]{"0", "1", "abc", "def", "ghi", "jkl",
                "mno", "pqrs", "tuv", "wxyz"};
		if(digits.length()==0) return result;
		result.add("");
		for(int i=0;i<digits.length();i++){
			int j=Character.getNumericValue(digits.charAt(i));
			while(result.peek().length()==i){   //每次取出队列中的已有字符串进行添加
				String tmp=result.remove();
				for(char s:map[j].toCharArray())
					result.add(tmp+s);
			}
		}
		return result;
    }
}
