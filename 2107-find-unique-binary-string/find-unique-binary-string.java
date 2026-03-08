class Solution {
    Set<Long> set  = new HashSet<>();
    public String findDifferentBinaryString(String[] nums) {
        for(String s: nums) set.add(Long.valueOf(s,2));
        long i = 0;
        while(set.contains(i))
            i++;
        String result = String.format("%" + nums[0].length() + "s", Long.toBinaryString(i)).replace(' ', '0');
        return result;
    }
    
}

