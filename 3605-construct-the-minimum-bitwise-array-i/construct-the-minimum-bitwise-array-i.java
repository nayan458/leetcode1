class Solution {
    private static int[] elems = new int[1001];
    static {
        for(int i = 1; i < 1000; i++)
            elems[i] = (i | (i+1));
    }

    public int[] minBitwiseArray(List<Integer> nums) {
        int[] ans = new int[nums.size()];
        for(int i = 0; i < nums.size(); i++){
            ans[i] = search(nums.get(i));
        }
        return ans;
    }

    private int search(int target) {
        for(int i = 1; i < target; i++){
            if(elems[i] == target)  return i;
        }
        return -1;
    }
}