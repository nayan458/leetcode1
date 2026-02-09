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
    private List<TreeNode> arr = new ArrayList<>();
    public TreeNode balanceBST(TreeNode root) {
        lnr(root);
        return balance(0,arr.size() - 1);
    }

    private TreeNode balance(int l, int r){
        if(l > r) return null;
        int mid = l + (r - l) / 2;
        TreeNode root = new TreeNode(arr.get(mid).val);
        root.left = balance(l,mid-1);
        root.right = balance(mid+1,r);
        return root;
    }

    private void lnr(TreeNode root){
        if(root == null)    return;
        lnr(root.left);
        arr.add(root);
        lnr(root.right);
    }
}