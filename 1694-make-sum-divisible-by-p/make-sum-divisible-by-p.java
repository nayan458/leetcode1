class Solution {
    public int minSubarray(int[] nums, int p) {
        long total = 0;
        for (int x : nums) total = (total + x) % p;

        if (total == 0) return 0;  
        long target = total;

        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, -1);
        
        long prefix = 0;
        int ans = nums.length;

        for (int i = 0; i < nums.length; i++) {
            prefix = (prefix + nums[i]) % p;
            long need = (prefix - target + p) % p;

            if (map.containsKey(need)) {
                ans = Math.min(ans, i - map.get(need));
            }

            map.put(prefix, i);
        }

        return ans == nums.length ? -1 : ans;
    }
}
