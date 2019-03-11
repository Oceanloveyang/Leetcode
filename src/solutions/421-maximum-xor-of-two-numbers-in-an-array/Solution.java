// Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.
//
// Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.
//
// Could you do this in O(n) runtime?
//
// Example:
//
// Input: [3, 10, 5, 25, 2, 8]
//
// Output: 28
//
// Explanation: The maximum result is 5 ^ 25 = 28.
//
//


public class Solution {
    public int findMaximumXOR(int[] nums) {
 		int max=0;
		int flag=0;
		
		for(int i=31;i>=0;i--){
			Set<Integer> prefixSet=new HashSet();
			flag=flag|(1<<i);
			for(int num:nums){
				prefixSet.add(num&flag);
			}
			
			int tmp=max|(1<<i);
			for(int prefix:prefixSet){
				if(prefixSet.contains(tmp^prefix)){
					max=tmp;
					break;
				}
			}
		}
		
		return max;       
    }
}
