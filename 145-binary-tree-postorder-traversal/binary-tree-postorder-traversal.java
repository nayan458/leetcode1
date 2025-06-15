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
    List li = new ArrayList();
    public List<Integer> postorderTraversal(TreeNode root) {
        // LRN
        if(root != null && root.left != null)
            postorderTraversal(root.left);
        if(root != null && root.right != null)
            postorderTraversal(root.right);
        if(root != null)
            li.add(root.val);
        return li;
    }
}