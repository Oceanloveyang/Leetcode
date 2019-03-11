// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
//
// Example 1:
//
//
// Input:
// 11110
// 11010
// 11000
// 00000
//
// Output: 1
//
//
// Example 2:
//
//
// Input:
// 11000
// 11000
// 00100
// 00011
//
// Output: 3
//


class Solution {
    public int numIslands(char[][] grid) {
       if(grid.length==0){
            return 0;
        }
        int row_length = grid.length;
        int col_length = grid[0].length;
        int num = 0;

        for(int i=0;i<row_length;i++){
            for(int j =0;j<col_length;j++){
                if(grid[i][j]=='1'){
                    num+=1;
                    CoverIslands(grid,i,j);
                }
            }
        }
        return num;
    }
    
    public void CoverIslands(char[][] grid, int i, int j){
        if(i>=0&&i<grid.length&&j>=0&&j<grid[0].length&&grid[i][j]=='1'){
            grid[i][j]='0';
            CoverIslands(grid,i-1,j);
            CoverIslands(grid,i+1,j);
            CoverIslands(grid,i,j+1);
            CoverIslands(grid,i,j-1);
        }
    }
    
}
