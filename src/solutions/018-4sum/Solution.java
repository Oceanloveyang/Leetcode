// Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
//
// Note:
//
// The solution set must not contain duplicate quadruplets.
//
// Example:
//
//
// Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
//
// A solution set is:
// [
//   [-1,  0, 0, 1],
//   [-2, -1, 1, 2],
//   [-2,  0, 0, 2]
// ]
//
//


class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> list = new ArrayList<>();
		Arrays.sort(nums);

		for(int i = 0; i < nums.length; i++) 
		{
			if(i == 0 || nums[i] != nums[i - 1])
			{
				threeSum(list, nums, i + 1, nums.length - 1, target - nums[i], nums[i]);
			}	
		}
		return list;
	}

	// Three Sum Problem: list.add(Arrays.asList(w, the three numbers))
	public void threeSum(List<List<Integer>> list, int[] A, int start, int end, int target, int w) 
	{
		for(int j = start; j < end; j++) 
		{
			if(j == start || A[j] != A[j - 1])
			{
				twoSum(list, A, j + 1, A.length - 1, target - A[j], w, A[j]);
			}
		}
	}

	// Two Sum Problem: list.add(Arrays.asList(w, x, the two numbers))
	public void twoSum(List<List<Integer>> list, int[] A, int start, int end, int target, int w, int x) 
	{
		while(start < end) 
		{
			int y = A[start];
			int z = A[end];

			if(y + z == target) 
			{
				list.add(Arrays.asList(w, x, y, z));
				while(start < end && A[start] == A[start + 1]) start++;
				while(start < end && A[end] == A[end - 1]) 	   end--;
                start++; end--;
			}
			else if(y + z < target)
			{
				start++;
			}
			else
			{
				end--;
			}
		}
	}
}
