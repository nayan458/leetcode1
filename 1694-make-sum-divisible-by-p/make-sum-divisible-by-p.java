class Solution {
    public int minSubarray(int[] nums, int p) {
        int need = sum(nums, p) % p;
        if(need == 0)
            return 0;
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(0,-1);
        int curIdx = 0;
        int ans = nums.length;
        int remainder = 0;
        for(int elem: nums) {
            remainder = ((remainder % p) + (elem % p)) % p;
            int target = (remainder - need + p) % p;
            if(hm.containsKey(target)) {
                int diff = curIdx - hm.get(target);
                ans = Math.min(diff,ans);
            }
            hm.put(remainder,curIdx);
            curIdx++;
        }
        return ans == nums.length ? -1 : ans;
    }

    private int sum(int[] nums, int p) {
        int add = 0;
        for(int elem: nums)
            add = ((add % p) + (elem % p)) % p;
        return add % p;
    }
}