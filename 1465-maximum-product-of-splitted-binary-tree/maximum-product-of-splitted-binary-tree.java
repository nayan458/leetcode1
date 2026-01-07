class Solution {
    private static final int MOD = 1_000_000_007;
    long maxProd = 0;
    long sum = 0;
    public int maxProduct(TreeNode root) {
        if(root == null) return 0;
        this.sum = lnrSum(root);
        lnr(root);
        return (int)(maxProd % MOD);
    }

    private long lnr(TreeNode root){
        if(root == null) return 0;
        long left = lnr(root.left);
        long right = lnr(root.right);
        long brokenLeft = left * (sum - left);
        long brokenRight = right * (sum - right) ;
        maxProd = Math.max(maxProd,Math.max(brokenLeft, brokenRight));
        return left + right + root.val;
    }

    private long lnrSum(TreeNode root){
        if(root == null) return 0;
        return lnrSum(root.left) + lnrSum(root.right) + root.val;
    }
}