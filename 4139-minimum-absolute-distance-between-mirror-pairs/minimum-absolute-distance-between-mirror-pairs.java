class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n = nums.length;
        int ans = n;

        Map<Integer, Integer> lastIndex = new HashMap<>(n);

        for (int j = 0; j < n; j++) {
            int x = nums[j];

            Integer i = lastIndex.get(x);
            if (i != null) {
                ans = Math.min(ans, j - i);
            }

            int rev = reverse(x);
            lastIndex.put(rev, j);
        }

        return ans < n ? ans : -1;
    }

    private int reverse(int x) {
        int rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }
}