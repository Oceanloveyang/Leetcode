// Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
//
// A region is captured by flipping all 'O's into 'X's in that surrounded region.
//
// Example:
//
//
// X X X X
// X O O X
// X X O X
// X O X X
//
//
// After running your function, the board should be:
//
//
// X X X X
// X X X X
// X X X X
// X O X X
//
//
// Explanation:
//
// Surrounded regions shouldn’t be on the border, which means that any 'O' on the border of the board are not flipped to 'X'. Any 'O' that is not on the border and it is not connected to an 'O' on the border will be flipped to 'X'. Two cells are connected if they are adjacent cells connected horizontally or vertically.
//


class Solution {
    public void solve(char[][] board) {
        
        int row_length = board.length;
        if(row_length==0){return;}
        int col_length = board[0].length;
        for(int i=0;i<row_length;i++){
            Filpped(board,i,0);
            Filpped(board,i,col_length-1);
        }
        for(int j=0;j<col_length;j++){
            Filpped(board,0,j);
            Filpped(board,row_length-1,j);
        }
        
        for(int i=0;i<row_length;i++){
            for(int j=0;j<col_length;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }
    
    private void Filpped(char[][] board, int i, int j){
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!='O'){
            return;
        }
        board[i][j]='T';
        Filpped(board,i,j+1);
        Filpped(board,i,j-1);
        Filpped(board,i-1,j);
        Filpped(board,i+1,j);
    }
    
}
