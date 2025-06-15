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

    public List<Integer> preorderTraversal(TreeNode root) {

        // NlR
        if(root != null)
            li.add(root.val);
        if(root != null && root.left != null)
            preorderTraversal(root.left);
        if(root != null && root.right != null)
            preorderTraversal(root.right);
        
        return li;
    }
}