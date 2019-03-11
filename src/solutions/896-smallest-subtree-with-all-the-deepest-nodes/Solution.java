// Given a binary tree rooted at root, the depth of each node is the shortest distance to the root.
//
// A node is deepest if it has the largest depth possible among any node in the entire tree.
//
// The subtree of a node is that node, plus the set of all descendants of that node.
//
// Return the node with the largest depth such that it contains all the deepest nodes in its subtree.
//
//  
//
// Example 1:
//
//
// Input: [3,5,1,6,2,0,8,null,null,7,4]
// Output: [2,7,4]
// Explanation:
//
//
//
// We return the node with value 2, colored in yellow in the diagram.
// The nodes colored in blue are the deepest nodes of the tree.
// The input "[3, 5, 1, 6, 2, 0, 8, null, null, 7, 4]" is a serialization of the given tree.
// The output "[2, 7, 4]" is a serialization of the subtree rooted at the node with value 2.
// Both the input and output have TreeNode type.
//
//
//  
//
// Note:
//
//
// 	The number of nodes in the tree will be between 1 and 500.
// 	The values of each node are unique.
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

    class MyPair {
    private int first;
    private TreeNode second;

    public MyPair(int first, TreeNode second) {
        this.first = first;
        this.second = second;
    }

    public int getKey() {
        return first;
    }

    public TreeNode getValue() {
        return second;
    }
}
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).getValue();
    }
    
    public MyPair deep(TreeNode root){
        if(root==null){
            return new MyPair(0,null);
        }   
        System.out.println("hello");
        MyPair lpair = deep(root.left);
        MyPair rpair = deep(root.right);
        int l = lpair.getKey();
        int r = rpair.getKey();
        if(l==r){
            return new MyPair(l+1,root);
        }
        else{
            return l>r?new MyPair(l+1,lpair.getValue()):new MyPair(r+1,rpair.getValue());
        }
    }
    
}
