class Solution {
    public int sumRootToLeaf(TreeNode root) {
        return nlr(root,0);
    }

    private int nlr(TreeNode root,int num) {
        if(root == null) return 0;

        num = ((num << 1) | root.val);

        if(root.left == null && root.right == null) return num;

        return nlr(root.left,num) + nlr(root.right,num);
    }
}