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
    private TreeNode min;
    private TreeNode left;
    private TreeNode right;
    
    public Solution(){
        min = null;
        left = null;
        right = null;
    }

    public void recoverTree(TreeNode root) {
        findNodes(root);
        
        min = new TreeNode(left.val);
        left.val = right.val;
        right.val = min.val;
        
    }

    private void findNodes(TreeNode root){       // inorder traversal
        if(root == null)       return;
        findNodes(root.left);
        if(min == null)
            min = root;
        else if(min.val >= root.val){
            if(left == null){
                left = min;
                right = root;
            }
            else{
                right = root;
                return;
            }
        }
        min = root;
        findNodes(root.right);
    }
}