// Given a string, sort it in decreasing order based on the frequency of characters.
//
// Example 1:
//
// Input:
// "tree"
//
// Output:
// "eert"
//
// Explanation:
// 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
//
//
//
// Example 2:
//
// Input:
// "cccaaa"
//
// Output:
// "cccaaa"
//
// Explanation:
// Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
// Note that "cacaca" is incorrect, as the same characters must be together.
//
//
//
// Example 3:
//
// Input:
// "Aabb"
//
// Output:
// "bbAa"
//
// Explanation:
// "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.
//
//


//public class Solution {
//    public String frequencySort(String s) {
//        Character[] chars = new Character[s.length()];
//    int[] count = new int[256];
//    for (int i = 0; i < s.length(); i++) {
//        char c = s.charAt(i);
//        count[c]++;
//        chars[i] = c;
//    }
//    Arrays.sort(chars, new CharComparator(count));
//    StringBuilder sb = new StringBuilder();
//    for (char c : chars) {
//        sb.append(c);
//    }
//    return sb.toString();
//    }
//    class CharComparator implements Comparator<Character> {
//    private int[] map;
//    public CharComparator(int[] map) {
//        this.map = map;
//    }
//    @Override
//    public int compare(Character a, Character b) {
//        return map[a] > map[b] ? -1 : (map[a] == map[b] ? (a - b) : 1);
//    }
//}
//}



public class Solution {
    public boolean Find(int target, int [][] array) {
        int length_row = array.length;
        int length_col = array[0].length;
        int row_end=-1;
        int row_count = 0;
        for(int i=0;i<length_row;i++){
            if(array[i][0]>=target&&array[i][length_col-1]<=target){
                row_end=i;
                row_count+=1;
            }
        }
        for(int k=0;k<length_col;k++){
            if(array[row_end-row_count+1][k]>=target&&array[row_end][k]<=target){
                for(int j=(row_end-row_count+1);j<=row_end;j++){
                    if(array[j][k]==target){
                        return true;
                    }

                }}
        }
        return false;

    }


    public void main(String args[]){
        Solution obj = new Solution();
        int [][]array=[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]];
        int target = 7;
        System.out.println(Find(target,array));

    }
}