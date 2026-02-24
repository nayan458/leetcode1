class Solution {
    int sum = 0;
    public int sumRootToLeaf(TreeNode root) {
        nlr(root,0);
        return sum;
    }

    private void nlr(TreeNode root,int num) {
        if(root == null)
            return;

        num <<= 1;
        if(root.val == 1)
            num |= 1;

        if(root.left == null && root.right == null){
            sum += num;
            return;
        }
        
        nlr(root.left,num);
        nlr(root.right,num);
    }
}