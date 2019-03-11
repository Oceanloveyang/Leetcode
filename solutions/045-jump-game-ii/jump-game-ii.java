// Given an array of non-negative integers, you are initially positioned at the first index of the array.
//
// Each element in the array represents your maximum jump length at that position.
//
// Your goal is to reach the last index in the minimum number of jumps.
//
// Example:
//
//
// Input: [2,3,1,1,4]
// Output: 2
// Explanation: The minimum number of jumps to reach the last index is 2.
//     Jump 1 step from index 0 to 1, then 3 steps to the last index.
//
// Note:
//
// You can assume that you can always reach the last index.
//


class Solution {
    public int jump(int[] nums) {
        int start = 0;
        int end = 0;
        int step = 0;
        int reach = 0;
        while(end<nums.length-1){
            step+=1;
            reach = end;
            for(int i=start;i<end+1;i++){
                if(i+nums[i]>reach){
                    reach = nums[i]+i;
                }
            }
            start = end+1;
            end = reach;
        }
        return step;
    }
}
