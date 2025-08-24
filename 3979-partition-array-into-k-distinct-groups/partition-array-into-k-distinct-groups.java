class Solution {
    public boolean partitionArray(int[] nums, int k) {
        if(nums.length % k != 0)
            return false;
        k = nums.length/k;
        Map<Integer, Integer> hm = new HashMap<>();
        for(int elem: nums){
            int freq = hm.getOrDefault(elem, 0);
            if(freq + 1 > k)
                    return false;
            hm.put(elem,  freq + 1);
        }
        return true;
    }
}