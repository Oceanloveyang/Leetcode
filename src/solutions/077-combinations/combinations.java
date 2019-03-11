// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
//
// Example:
//
//
// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
//
//


class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        backtracking(n,k,1,res,list);
        return res;
     }
    
    public void backtracking(int n, int k, int index, List<List<Integer>> res, List<Integer> list){
        if(list.size()==k){
            res.add(new ArrayList<Integer>(list));
            return;
        }        
        for(int i = index;i<=n;i++){
           list.add(i);
           backtracking(n,k,i+1,res,list);
           list.remove(list.size()-1);
        }       
 }
	// public static List<List<Integer>> combine(int n, int k) {
	// 	List<List<Integer>> combs = new ArrayList<List<Integer>>();
	// 	combine(combs, new ArrayList<Integer>(), 1, n, k);
	// 	return combs;
	// }
	// public static void combine(List<List<Integer>> combs, List<Integer> comb, int start, int n, int k) {
	// 	if(k==0) {
	// 		combs.add(new ArrayList<Integer>(comb));
	// 		return;
	// 	}
	// 	for(int i=start;i<=n;i++) {
	// 		comb.add(i);
	// 		combine(combs, comb, i+1, n, k-1);
	// 		comb.remove(comb.size()-1);
	// 	}
	// }
}
