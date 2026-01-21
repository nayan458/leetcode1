class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++){
            ans[i] = search(nums.get(i));
        }
        return ans;
    }

    private int search(int target) {
        if((target & 1) == 0)   return -1;
        int i = 0;
        while((target & (1 << i)) != 0)
            i++;
            
        return target & ~(1 << (i-1));
    }

}