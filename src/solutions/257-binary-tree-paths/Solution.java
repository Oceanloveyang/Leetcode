// Given a binary tree, return all root-to-leaf paths.
//
// Note: A leaf is a node with no children.
//
// Example:
//
//
// Input:
//
//    1
//  /   \
// 2     3
//  \
//   5
//
// Output: ["1->2->5", "1->3"]
//
// Explanation: All root-to-leaf paths are: 1->2->5, 1->3
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new ArrayList<>();
        backtrack(list, "", root);
        return list;
    }
    
    public void backtrack(List<String> list, String str, TreeNode root){
        if(root!=null){
            str += Integer.toString(root.val);
            if((root.left==null)&&(root.right==null)){
                 list.add(str);
            }else{
                str+="->";
                backtrack(list, str, root.left);
                backtrack(list, str, root.right);
            }
        }
    }
}
