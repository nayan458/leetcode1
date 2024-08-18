class Solution {
    public int singleNumber(int[] nums) {
        HashMap <Integer, Integer> hm = new HashMap <>();
        for(int elem : nums)
            hm.put(elem,hm.getOrDefault(elem,0)+1);
        
        for(Map.Entry<Integer, Integer> e : hm.entrySet())
            if(e.getValue() == 1)
                return (int)e.getKey();
        return -1;
    }
}