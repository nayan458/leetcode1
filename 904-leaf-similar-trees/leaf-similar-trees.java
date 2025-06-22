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
    List<Integer> t1 = new ArrayList<>();
    List<Integer> t2 = new ArrayList<>();

    private void inorder1(TreeNode root){
        if(root == null)
            return;
        if(root.right == root.left)
            t1.add(root.val);
        if(root.left != null)
            inorder1(root.left);
        if(root.right != null)
            inorder1(root.right);
        return;
    }
    private void inorder2(TreeNode root){
        if(root == null)
            return;
        if(root.right == root.left)
            t2.add(root.val);
        if(root.left != null)
            inorder2(root.left);
        if(root.right != null)
            inorder2(root.right);
        return;
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        inorder1(root1);
        inorder2(root2);

        return t1.equals(t2);
    }
}