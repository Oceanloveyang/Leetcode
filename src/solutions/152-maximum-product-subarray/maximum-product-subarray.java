// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
//
// Example 1:
//
//
// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.
//
//
// Example 2:
//
//
// Input: [-2,0,-1]
// Output: 0
// Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
//


class Solution {
    public int maxProduct(int[] nums) {
       int n = nums.length;
        int max = nums[0];
        int maxtmp = max;
        int mintmp = max;
        for(int i=1; i<n;i++){
            int maxtmp_2= Math.max(maxtmp*nums[i],mintmp*nums[i]);
            mintmp = Math.min(maxtmp*nums[i],mintmp*nums[i]);
            maxtmp = maxtmp_2;
            maxtmp = Math.max(maxtmp,nums[i]);
            mintmp = Math.min(mintmp,nums[i]);
            max = Math.max(max,maxtmp);
        }
        
    return max;
    }
}
