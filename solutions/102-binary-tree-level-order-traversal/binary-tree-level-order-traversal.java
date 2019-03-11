// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
//
//
// For example:
// Given binary tree [3,9,20,null,null,15,7],
//
//     3
//    / \
//   9  20
//     /  \
//    15   7
//
//
//
// return its level order traversal as:
//
// [
//   [3],
//   [9,20],
//   [15,7]
// ]
//
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        levelOrderTraverse(root,0,lists);
        return lists;
    }
    private void levelOrderTraverse(TreeNode root, int depth, List<List<Integer>> lists){
        if(root==null){
            return;
        }
        if(lists.size()<=depth){
            lists.add(new ArrayList<>());
        }
        lists.get(depth).add(root.val);
        levelOrderTraverse(root.left,depth+1,lists);
        levelOrderTraverse(root.right,depth+1,lists);
    }
}
