class Solution {
    private TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    private boolean inorder(TreeNode node) {
        if (node == null) return true;

        // Check left subtree
        if (!inorder(node.left)) return false;

        // Current node must be greater than previous node
        if (prev != null && node.val <= prev.val) return false;
        prev = node;

        // Check right subtree
        return inorder(node.right);
    }
}
