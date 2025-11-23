class Solution {
    public int maxSumDivThree(int[] nums) {
        int[] dp = new int[]{0, Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int x : nums) {
            int[] next = dp.clone();

            for (int r = 0; r < 3; r++) {
                int nr = (r + x) % 3;
                next[nr] = Math.max(next[nr], dp[r] + x);
            }

            dp = next;
        }

        return dp[0];
    }
}
