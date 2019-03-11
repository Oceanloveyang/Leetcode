// Given an array of integers, return indices of the two numbers such that they add up to a specific target.
//
// You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
// Example:
//
//
// Given nums = [2, 7, 11, 15], target = 9,
//
// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].
//
//
//  
//


class Solution {
    public int[] twoSum(int[] nums, int target) {
if(null == nums) return null;
		int[] res = new int[2];

		int[] nums2 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums2);

		//find sum factor a and b
		int a = 0; int b = 0;
		int start = 0; int end = nums.length - 1;
		while (start < end) {
			if (nums2[start] + nums2[end] < target) {
				start++;
			} else if(nums2[start] + nums2[end] > target) {
				end--;
			} else {
                a = nums2[start]; b = nums2[end];
				break;
			}
		}

		for (int i = 0; i < nums.length; i++) {
			if (a == nums[i]) {
				res[0] = i;
				break;
			}
		}

		if (a == b) {
			for (int j = res[0]+1; j < nums.length; j++) {
				if (b == nums[j]) {
					res[1] = j;
					break;
				}
			}
		} else {
			for (int j = 0; j < nums.length; j++) {
				if (b == nums[j]) {
					res[1] = j;
					break;
				}
			}
		}
		return res;
	}
}
