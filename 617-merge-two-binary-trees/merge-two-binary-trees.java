class Solution {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode t = null;
        if(root1 != null && root2 != null)
            t = new TreeNode((root1.val + root2.val));
        else if(root1 == null)
            return root2;
        else
            return root1;

        t.left = mergeTrees(root1.left,root2.left);
        t.right = mergeTrees(root1.right,root2.right);

        return t;
    }
}