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
    private TreeNode dummy = new TreeNode();
    private TreeNode temp = dummy;
    
    public TreeNode increasingBST(TreeNode root) {
        inorder(root);
        return dummy.right;
    }

    private void inorder(TreeNode root){
        if(root == null) 
            return;
        inorder(root.left);
            temp.right = new TreeNode(root.val);
            temp = temp.right;
        inorder(root.right);
    }
}