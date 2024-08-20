class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        HashMap <Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            if(!hm.containsKey(nums[i]))
                hm.put(nums[i],i);
            else {
                int index_of_i = hm.get(nums[i]);
                if(Math.abs(index_of_i - i) <= k)
                    return true;
                hm.put(nums[i],i);
            }

        }
        return false;
    }
}