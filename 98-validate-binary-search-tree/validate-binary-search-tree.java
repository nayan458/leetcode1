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
    private TreeNode min = null;
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        boolean left = isValidBST(root.left);
        if(min != null && min.val >= root.val)
            return false;
        min = root;
        boolean right = isValidBST(root.right);
        return left && right;
    }
}
// class Solution {

//     private long min = Long.MIN_VALUE;    

//     public boolean isValidBST(TreeNode root) {
//         if(root == null)
//             return true;

//         if( !isValidBST(root.left))
//             return false;

//         if(root.val <= min)
//             return false;

//         min = root.val;

//         return isValidBST(root.right);
//     }
// }
