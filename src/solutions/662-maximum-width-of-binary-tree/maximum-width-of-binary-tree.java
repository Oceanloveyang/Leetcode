// Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.
//
// The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.
//
// Example 1:
//
//
// Input: 
//
//            1
//          /   \
//         3     2
//        / \     \  
//       5   3     9 
//
// Output: 4
// Explanation: The maximum width existing in the third level with the length 4 (5,3,null,9).
//
//
// Example 2:
//
//
// Input: 
//
//           1
//          /  
//         3    
//        / \       
//       5   3     
//
// Output: 2
// Explanation: The maximum width existing in the third level with the length 2 (5,3).
//
//
// Example 3:
//
//
// Input: 
//
//           1
//          / \
//         3   2 
//        /        
//       5      
//
// Output: 2
// Explanation: The maximum width existing in the second level with the length 2 (3,2).
//
//
// Example 4:
//
//
// Input: 
//
//           1
//          / \
//         3   2
//        /     \  
//       5       9 
//      /         \
//     6           7
// Output: 8
// Explanation:The maximum width existing in the fourth level with the length 8 (6,null,null,null,null,null,null,7).
//
//
//
//
// Note: Answer will in the range of 32-bit signed integer.
//


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// class Solution {
//     int ans;
//     Map<Integer, Integer> left;
//     public int widthOfBinaryTree(TreeNode root) {
//         ans = 0;
//         left = new HashMap();
//         dfs(root, 0 , 0);
//         return ans;
//     }
    
//     public void dfs(TreeNode root, int depth, int pos){
//         if(root==null) return;
//         left.computeIfAbsent(depth,x->pos);
//         ans = Math.max(ans, pos - left.get(depth)+1);
//         dfs(root.left, depth+1,2*pos);
//         dfs(root.right, depth+1,2*pos+1);
//     }
// }

class Solution{
    public int widthOfBinaryTree(TreeNode root){
        if (root == null) {
            return 0;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        root.val = 0;
        int max = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            max = Math.max(max, queue.peekLast().val - queue.peekFirst().val + 1);
            for (int i = 0; i < size; i++) {
                root = queue.poll();
                if (root.left != null) {
                    root.left.val = root.val * 2;
                    queue.offer(root.left);
                }
                if (root.right != null) {
                    root.right.val = root.val * 2 + 1;
                    queue.offer(root.right);
                }
            }
        }
        return max;
    }
    
}
