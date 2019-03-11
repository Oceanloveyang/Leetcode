// Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.
//
// Note:
//
// The solution set must not contain duplicate triplets.
//
// Example:
//
//
// Given array nums = [-1, 0, 1, 2, -1, -4],
//
// A solution set is:
// [
//   [-1, 0, 1],
//   [-1, -1, 2]
// ]
//
//


public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
     		List<List<Integer>> result=new ArrayList<List<Integer>>();
		if(nums.length==0||nums.length<3)
			return result;
		Arrays.sort(nums);
		for(int i=0;i<nums.length-2;i++){
			if(i==0||nums[i]>nums[i-1]){
				int j=i+1;
				int k=nums.length-1;
				while(j<k){
					if(nums[i]+nums[j]+nums[k]==0){
						List<Integer> tmp=new ArrayList<Integer>();
						tmp.add(nums[i]);
						tmp.add(nums[j]);
						tmp.add(nums[k]);
						result.add(tmp);
						j++;
						k--;
						
						while(j<k&&nums[j]==nums[j-1])
							j++;
						while(j<k&&nums[k]==nums[k+1])
							k--;
					}else if(nums[i]+nums[j]+nums[k]<0){
					j++;
				}else{
					k--;
				}
			}
		}
	}
	return result;   
    }
}
