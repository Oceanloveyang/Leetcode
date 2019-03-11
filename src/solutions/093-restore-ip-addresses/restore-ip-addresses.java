// Given a string containing only digits, restore it by returning all possible valid IP address combinations.
//
// Example:
//
//
// Input: "25525511135"
// Output: ["255.255.11.135", "255.255.111.35"]
//
//


class Solution {
public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(s, 0, new String[4], res);
        return res;
    }
    
    void dfs(String s, int index, String[] places, List<String> res){
        if (index == 3){
            if (validNumber(s)){
                places[index] = s;
                res.add(String.join(".",places));
            }
            return;  
         }
        //We still have some string parsing to do .
        for (int i = 0; i < Math.min(3, s.length()); i++){
            String currentPiece = s.substring(0, i+1);
            if (validNumber(currentPiece)){
                places[index] = currentPiece;
                dfs(s.substring(i+1), index+1, places, res);
            }
        }
    }
    
    boolean validNumber(String s){
        if (s.length() == 0) return false;
        if (s.length() > 3) return false;
        //No leading zeros allowed.
        if (s.length() > 1 && s.charAt(0) == '0') return false;
        int num = Integer.parseInt(s);
        return 0 <= num && num <= 255;
    }
}
