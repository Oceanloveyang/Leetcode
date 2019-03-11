// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
//
// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
//
// Now consider if some obstacles are added to the grids. How many unique paths would there be?
//
//
//
// An obstacle and empty space is marked as 1 and 0 respectively in the grid.
//
// Note: m and n will be at most 100.
//
// Example 1:
//
//
// Input:
// [
//   [0,0,0],
//   [0,1,0],
//   [0,0,0]
// ]
// Output: 2
// Explanation:
// There is one obstacle in the middle of the 3x3 grid above.
// There are two ways to reach the bottom-right corner:
// 1. Right -> Right -> Down -> Down
// 2. Down -> Down -> Right -> Right
//
//


class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        
        int[][] dp = new int[m+1][n+1];
        
        for(int i = 1; i<=m;i++){
            for(int j = 1;j<=n;j++){                
                if(obstacleGrid[i-1][j-1]==1){
                    dp[i][j]=0;
                }else if(i==1&&j==1){
                    dp[i][j]=1;
                }else
                {
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
                System.out.println(dp[i][j]);
            }
        }
        return dp[m][n];
    }
}
