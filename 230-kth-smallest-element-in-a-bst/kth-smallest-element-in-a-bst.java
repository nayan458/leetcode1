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
    Stack<TreeNode> stR = new Stack<>();
    private int ans;
    private int k;
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
        inorder(root);
        return ans;
    }

    private void inorder(TreeNode root){
        if(root == null)   return;

        inorder(root.left);
        if(k-- == 1){
            ans = root.val;
            return;
        }
        inorder(root.right);
    }

        // pushNode(root);
        // while(!stR.isEmpty() && (k - 1 > 0))
        //     pushNode(stR.pop().right);
        
        // return stR.pop().val;

    // private void pushNode(TreeNode root){
    //     while(root != null){
    //         stR.push(root);
    //         root = root.left;
    //     }
    // }
}