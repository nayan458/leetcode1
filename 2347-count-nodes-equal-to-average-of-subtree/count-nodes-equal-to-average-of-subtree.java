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
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        lrnSum(root);
        
        return count;
    }

    private int[] lrnSum(TreeNode root) {
        if(root == null)
            return new int[]{0,0};

        int[] left = lrnSum(root.left);
        int[] right = lrnSum(root.right);

        int sum = left[0] + right[0] + root.val;
        int total = left[1] + right[1] + 1;

        if(sum/total == root.val)   count++;
        return new int[]{sum, total};
    }

}