//
// Given a sorted array consisting of only integers where every element appears twice except for one element which appears once. Find this single element that appears only once. 
//
//
// Example 1:
//
// Input: [1,1,2,3,3,4,4,8,8]
// Output: 2
//
//
//
// Example 2:
//
// Input: [3,3,7,7,10,11,11]
// Output: 10
//
//
//
// Note:
// Your solution should run in O(log n) time and O(1) space.
//
//


class Solution {
    public int singleNonDuplicate(int[] nums) {
        int length = nums.length;
        for(int i=0;i<length;i+=2){
            if(nums[i]+nums[length-1-i]!=nums[i+1]+nums[length-1-i-1]){
                if(nums[i]!=nums[i+1]){
                    return nums[i];
                }else{
                    return nums[length-1-i];
                }
            }
        }
        return -1;
    }
}
