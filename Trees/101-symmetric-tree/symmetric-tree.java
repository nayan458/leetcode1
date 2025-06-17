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
    private boolean isSame(TreeNode t1, TreeNode t2) {
        if(t1 == t2)
            return true;
        if(t1 != null && t2 != null)
            if(t1.val == t2.val)
                return true && isSame(t1.left,t2.right) && isSame(t1.right, t2.left);
        return false;
    }
    public boolean isSymmetric(TreeNode root) {
        return true && isSame(root.left, root.right);
    }
}