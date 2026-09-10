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
    Map<TreeNode, Integer> hmSum = new HashMap<>();
    Map<TreeNode, Integer> hmNodes = new HashMap<>();
    int count = 0;

    public int averageOfSubtree(TreeNode root) {
        lrnNodes(root);
        lrnSum(root);
        for(TreeNode key: hmSum.keySet())
            if(hmSum.get(key)/hmNodes.get(key) == key.val)
                count++;
        return count;
    }

    private int lrnSum(TreeNode root) {
        if(root == null)
            return 0;
        int left = lrnSum(root.left);
        int right = lrnSum(root.right);
        int sum = root.val + left + right;
        hmSum.put(root, sum);
        return sum;
    }

    private int lrnNodes(TreeNode root) {
        if(root == null)
            return 0;
        int total = lrnNodes(root.left) + lrnNodes(root.right) + 1;
        hmNodes.put(root,total);
        return total;
    }
}