class Solution {
    static {
        int[] nums = new int[] {5,3,6,1,12};
        for(int i = 0; i < 500; i++)
            findFinalValue(nums, i);
    }
    public static int findFinalValue(int[] nums, int original) {
        boolean[] set = new boolean[1001];
        for(int elem: nums) {
            set[elem] = true;
            while(original <= 1000 && set[original])
                original *= 2;
            if(original > 1000)
                return original;
        }
        return original;
    }
}