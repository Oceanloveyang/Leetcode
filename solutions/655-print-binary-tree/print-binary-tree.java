// Print a binary tree in an m*n 2D string array following these rules: 
//
//
// The row number m should be equal to the height of the given binary tree.
// The column number n should always be an odd number.
// The root node's value (in string format) should be put in the exactly middle of the first row it can be put. The column and the row where the root node belongs will separate the rest space into two parts (left-bottom part and right-bottom part). You should print the left subtree in the left-bottom part and print the right subtree in the right-bottom part. The left-bottom part and the right-bottom part should have the same size. Even if one subtree is none while the other is not, you don't need to print anything for the none subtree but still need to leave the space as large as that for the other subtree. However, if two subtrees are none, then you don't need to leave space for both of them. 
// Each unused space should contain an empty string "".
// Print the subtrees following the same rules.
//
//
// Example 1:
//
// Input:
//      1
//     /
//    2
// Output:
// [["", "1", ""],
//  ["2", "", ""]]
//
//
//
//
// Example 2:
//
// Input:
//      1
//     / \
//    2   3
//     \
//      4
// Output:
// [["", "", "", "1", "", "", ""],
//  ["", "2", "", "", "", "3", ""],
//  ["", "", "4", "", "", "", ""]]
//
//
//
// Example 3:
//
// Input:
//       1
//      / \
//     2   5
//    / 
//   3 
//  / 
// 4 
// Output:
//
// [["",  "",  "", "",  "", "", "", "1", "",  "",  "",  "",  "", "", ""]
//  ["",  "",  "", "2", "", "", "", "",  "",  "",  "",  "5", "", "", ""]
//  ["",  "3", "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]
//  ["4", "",  "", "",  "", "", "", "",  "",  "",  "",  "",  "", "", ""]]
//
//
//
// Note:
// The height of binary tree is in the range of [1, 10].
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
    public List<List<String>> printTree(TreeNode root) {
        List<List<String>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        
        int rows = getHeight(root);
        int cols = (int)Math.pow(2, rows) - 1;
        for (int i = 0; i < rows; i++) {
            List<String> row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                row.add("");
            }
            res.add(row);
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<int[]> indexQ = new LinkedList<>();
        queue.offer(root);
        indexQ.offer(new int[] { 0, cols - 1 });
        int row = -1;
        while (!queue.isEmpty()) {
            row++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                int[] indices = indexQ.poll();
                
                if (cur == null) {
                    continue;
                }
                
                int left = indices[0];
                int right = indices[1];
                int mid = left + (right - left) / 2;
                res.get(row).set(mid, String.valueOf(cur.val));
                
                queue.offer(cur.left);
                queue.offer(cur.right);
                indexQ.offer(new int[] { left, mid - 1 });
                indexQ.offer(new int[] { mid + 1, right });
            }
        }
        
        return res;
    }
    
    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }
}
