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
    private int count = 0;
    private void addLeftLeaf(TreeNode root, boolean isLeft){
        if(root == null)
            return;
        if(isLeft && root.left == root.right){
            count += root.val;
            return;
        }
        addLeftLeaf(root.left, true);
        addLeftLeaf(root.right, false);
    }
    public int sumOfLeftLeaves(TreeNode root) {
        addLeftLeaf(root, false);
        return count;
    }
}