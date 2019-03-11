//
// Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
//
// Note:
//
//
// 	All numbers will be positive integers.
// 	The solution set must not contain duplicate combinations.
//
//
// Example 1:
//
//
// Input: k = 3, n = 7
// Output: [[1,2,4]]
//
//
// Example 2:
//
//
// Input: k = 3, n = 9
// Output: [[1,2,6], [1,3,5], [2,3,4]]
//
//


class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        dfs(k,n,res,list,0 , 1, 0);
        return res;
    }
    
    public void dfs(int k, int n, List<List<Integer>> res, List<Integer> list, int sum, int index, int nums){
        if(sum == n&& nums==k){
            res.add(new ArrayList<Integer>(list));
            return;
        }
        if(sum<n&&nums<k){
            for(int i = index;i<=9;i++){
                if(sum+i<=n){
                    list.add(i);
                    sum+=i;
                    dfs(k,n,res,list,sum,i+1,nums+1);
                    sum-=i;
                    list.remove(list.size()-1);
                }
            }
        }else{
            return;
        }
        
        
    }
    
}
