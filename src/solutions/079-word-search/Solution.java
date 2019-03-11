// Given a 2D board and a word, find if the word exists in the grid.
//
// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
//
// Example:
//
//
// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]
//
// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.
//
//


class Solution {
    static boolean[][] boardVisited;
    public boolean exist(char[][] board, String word) {
        int n = board.length;
        int m = board[0].length;
        boardVisited = new boolean[n][m];
        if(word==""){
            return false;
        }
        boolean res = false;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
            if(board[i][j]==word.charAt(0)&&findExist(board,i,j,0,word)){
                    return true;
                }
            }
        }
        return res;
    }
        
    public boolean findExist(char[][] board,int i, int j, int index, String word){
    if(index==word.length()){
        return true;
    }
    if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || boardVisited[i][j]){
            return false;
        }
            
     boardVisited[i][j] = true;
        if(findExist(board, i-1, j, index+1, word) || 
           findExist(board, i+1, j, index+1, word) ||
           findExist(board,  i, j-1, index+1, word) || 
           findExist(board,  i, j+1, index+1, word)){
            return true;
        }
        
        boardVisited[i][j] = false;
        return false;       
    }
    
}
