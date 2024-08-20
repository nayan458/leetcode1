class Solution {
    public int[] frequencySort(int[] nums) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        for(int elem : nums)
            hm.put(elem, hm.getOrDefault(elem,0)+1);
        
        Integer temp[] = new Integer[nums.length];

        for(int i = 0;  i < nums.length; i++)
            temp[i] = nums[i];
        
        
         Arrays.sort(temp, new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                if(hm.get(a) == hm.get(b)){
                    return b-a;
                }
                return hm.get(a) - hm.get(b);
            }
        });

        for(int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }

        return nums;
    }
}