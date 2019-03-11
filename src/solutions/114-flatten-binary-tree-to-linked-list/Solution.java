// Given a binary tree, flatten it to a linked list in-place.
//
// For example, given the following tree:
//
//
//     1
//    / \
//   2   5
//  / \   \
// 3   4   6
//
//
// The flattened tree should look like:
//
//
// 1
//  \
//   2
//    \
//     3
//      \
//       4
//        \
//         5
//          \
//           6
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
    public void flatten(TreeNode root) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        if(root==null){
            return;
        }
        Traversal(root, queue);
        root = queue.poll();
        root.left = null;
        TreeNode tmp,tmp_root = null;
        tmp_root = root;
        while(!queue.isEmpty()){
            tmp=queue.poll();
            tmp.left = null;
            tmp_root.right = tmp;
            tmp_root = tmp;
        }
    }
    
    public void Traversal(TreeNode node, LinkedList<TreeNode> queue){
        if(node==null){
            return;
        }
        
        queue.offer(node);
        Traversal(node.left, queue);
        Traversal(node.right, queue);
    }
}
