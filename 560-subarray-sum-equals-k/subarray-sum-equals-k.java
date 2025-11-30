class Solution {
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0;
        hm.put(0,1);
        for(int elem: nums) {
            sum += elem;
            if(hm.containsKey(sum - k))
                ans += hm.get(sum - k);
            hm.put(sum,hm.getOrDefault(sum,0) + 1);
        }
        return ans;
    }
}