class Solution {
    public int maxScore(int[] nums) {
        long result = 0;
        int count = 0;
        Arrays.sort(nums);

        int i = nums.length - 1;
        while(i >= 0 && result + nums[i] > 0) {
            result += nums[i];
            count++;
            i--;
        }

        return count;
    }
}