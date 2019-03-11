// Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.
//
// Each number in candidates may only be used once in the combination.
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
// Input: candidates = [10,1,2,7,6,1,5], target = 8,
// A solution set is:
// [
//   [1, 7],
//   [1, 2, 5],
//   [2, 6],
//   [1, 1, 6]
// ]
//
//
// Example 2:
//
//
// Input: candidates = [2,5,2,1,2], target = 5,
// A solution set is:
// [
//   [1,2,2],
//   [5]
// ]
//
//


class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
                dfs(candidates, res, list, target, sum, i+1);
                sum-=candidates[i];
                list.remove(list.size()-1);
            }
            while(i<candidates.length-1&&candidates[i+1]==candidates[i]){
                i++;
            }
        }
    }
}
