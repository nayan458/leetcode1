class Solution {
    public int minMirrorPairDistance(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i])) {
                min = Math.min(min, i - hm.get(nums[i]));
            }

            int rev = reverse(nums[i]);
            if (rev != -1) {
                hm.put(rev, i);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int reverse(int x) {
        long rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev > Integer.MAX_VALUE ? -1 : (int) rev;
    }
}