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
    public void flatten(TreeNode root) {
        if(root == null) return;

        flatten(root.left);
        flatten(root.right);
        TreeNode rightp = root.right;
        TreeNode leftp = root.left; 
        
        while(leftp != null && leftp.right != null)
            leftp = leftp.right;
        if(leftp != null){
            leftp.right = rightp;
            root.right = root.left;
            root.left = null;
        }
    }
}