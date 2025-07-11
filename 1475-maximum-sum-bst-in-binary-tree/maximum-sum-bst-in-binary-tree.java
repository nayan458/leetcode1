class Solution {
    private int max = 0;

    public int maxSumBST(TreeNode root) {
        findMax(root);
        return max;
    }

    private ValidSum findMax(TreeNode root) {
        if (root == null) return new ValidSum(true, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);

        ValidSum left = findMax(root.left);
        ValidSum right = findMax(root.right);

        // If both left and right are valid BSTs and current root fits the rule
        if (left.valid && right.valid && root.val > left.max && root.val < right.min) {
            int sum = root.val + left.sum + right.sum;
            max = Math.max(max, sum);
            int min = Math.min(root.val, left.min);
            int maxVal = Math.max(root.val, right.max);
            return new ValidSum(true, min, maxVal, sum);
        }

        // If invalid
        return new ValidSum(false, 0, 0, 0);
    }
}

class ValidSum {
    boolean valid;
    int min, max, sum;

    public ValidSum(boolean valid, int min, int max, int sum) {
        this.valid = valid;
        this.min = min;
        this.max = max;
        this.sum = sum;
    }
}
