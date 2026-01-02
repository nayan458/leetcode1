class Solution {
    public int repeatedNTimes(int[] nums) {
        Map<Integer,Integer> hm = new HashMap<>();
        int n = nums.length/2;
        
        for(int elem: nums)
            hm.put(elem,hm.getOrDefault(elem,0)+1);
        
        for(Map.Entry<Integer, Integer> entry: hm.entrySet())
            if(entry.getValue() == n)   return entry.getKey();
        
        return -1;
    }
}