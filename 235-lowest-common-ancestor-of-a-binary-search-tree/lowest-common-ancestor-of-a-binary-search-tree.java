class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(p.val > q.val)
            return LCA(root, q, p);
        return LCA(root, p, q);
    }

    private TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if((p.val < root.val && q.val > root.val) || (p.val == root.val || q.val == root.val))
            return root;
        if(p.val < root.val && q.val < root.val)
            return LCA(root.left, p, q);
        else
            return LCA(root.right, p, q);
    }
}