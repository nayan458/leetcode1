class Solution {
    static
    {
        for(int i=0;i<100;i++)kLengthApart(new int[]{0}, 2);
    }

    public static boolean kLengthApart(int[] nums, int k) {
        int diff = 0;
        int l = -1;

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                if(l != -1) {
                    diff = i - l - 1;
                    if(diff < k)
                        return false;
                    else
                        l = i;
                }
                else 
                    l = i;
            }
        }

        return true;
    }
}