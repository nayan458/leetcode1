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
    private int sums(TreeNode root, int previousSum) {
        if(root == null)
            return 0;
        previousSum = (previousSum * 10) + root.val;

        if(root.left == root.right)
            return previousSum;
            
        return sums(root.left, previousSum) + sums(root.right, previousSum);
    }
    public int sumNumbers(TreeNode root) {
        return sums(root, 0);
    }
}