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

// Approach I: Solve by converting into an Array
class Solution {
    private List<Integer> arr = new ArrayList<>();

    public boolean findTarget(TreeNode root, int k) {
        if(root == null && root.right == root.left)
            return false;

        inorder(root);

        int right = arr.size() - 1, left = 0;
        while(left < right){
            int target = (arr.get(left) + arr.get(right));
            if( target == k)
                return true;
            if( target > k)
                right--;
            else
                left++;
        }

        return false;
    }

    private void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        arr.add(root.val);
        inorder(root.right);
    }
}