// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.
//
// Example:
//
//
// Input: [1,2,3,null,5,null,4]
// Output: [1, 3, 4]
// Explanation:
//
//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
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
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }
        queue.offer(root);
        TreeNode tmp;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
               tmp = queue.poll();
                if(i==size-1){
                  list.add(tmp.val);
              }             
              if(tmp.left!=null){
                queue.offer(tmp.left);
              }
              if(tmp.right!=null){
                queue.offer(tmp.right);
              }
            }

        }
        return list;
    }
}
