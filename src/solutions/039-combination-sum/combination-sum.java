// Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
// The same repeated number may be chosen from candidates unlimited number of times.
//
// Note:
//
//
// 	All numbers (including target) will be positive integers.
// 	The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
// Input: candidates = [2,3,6,7], target = 7,
// A solution set is:
// [
//   [7],
//   [2,2,3]
// ]
//
//
// Example 2:
//
//
// Input: candidates = [2,3,5], target = 8,
// A solution set is:
// [
//   [2,2,2,2],
//   [2,3,3],
//   [3,5]
// ]
//
//


import java.util.Arrays;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        Arrays.sort(candidates);
        dfs(candidates,res,list,target,0,0);
        return res;
    }
    
    public void dfs(int[] candidates, List<List<Integer>> res,List<Integer> list, int target, int sum, int index){
        if(sum == target){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for(int i=index;i<candidates.length;i++){
            if(sum+candidates[i]>target){
                break;
            }else{
                sum+=candidates[i];
                list.add(candidates[i]);
                dfs(candidates, res, list, target, sum, i);
                sum-=candidates[i];
                list.remove(list.size()-1);
            }
        }
    }
}
