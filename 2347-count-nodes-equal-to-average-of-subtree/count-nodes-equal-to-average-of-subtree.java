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
            return new int[2];
        int[] left = lrnSum(root.left);
        int[] right = lrnSum(root.right);

        int sum = root.val + left[0] + right[0];
        int total =  1 + left[1] + right[1];

        if(root.val == sum/total)   count++;
        return new int[]{sum, total};
    }

}