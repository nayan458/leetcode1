class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        return maxDiff(nums);
        // int l = 0;
        // int r = nums[nums.length - 1] + nums[nums.length - 2];

        // int minDiff = r;
        // while(l <= r) {
        //     int mid = l + (r-l)/2;
        //     int x = isPossible(mid);
        //     if(0 >= x) {
        //         if(x == 0)
        //             minDiff = Math.min(minDiff, mid);
        //         r = mid - 1;
        //     }
        //     else
        //         l = mid + 1;
        // }
        // return minDiff;
    }

    // private int isPossible() {

    // }

    private int maxDiff(int[] nums){
        int max = 0;
        for(int i = 0; i < nums.length / 2; i++) {
            max = Math.max((nums[i] + nums[nums.length - i - 1]), max);
        }
        return max;
    }
}
