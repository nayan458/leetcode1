class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        int remainder = 0;
        long sum = 0;
        int count = 0;
        for(int elem: nums) {
            sum += (long)elem;
            remainder = (int)(sum % k);
            remainder = (remainder + k) % k;
            if(hm.containsKey(remainder))
                count += hm.get(remainder);
            hm.put(remainder,hm.getOrDefault(remainder,0) + 1);
        }
        return count;
    }
}