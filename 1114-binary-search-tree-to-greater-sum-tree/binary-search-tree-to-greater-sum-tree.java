/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int counter = 0;
    public TreeNode bstToGst(TreeNode root) {
        if(root == null)
            return root;
        bstToGst(root.right);
        root.val += counter;
        counter = root.val;
        bstToGst(root.left);
        return root;
    }
}