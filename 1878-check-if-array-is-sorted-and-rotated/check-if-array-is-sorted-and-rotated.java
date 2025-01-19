class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int countDecreasing = 0;

        for (int i = 0; i < n; i++) {
            // Check if the current element is greater than the next element (modulo n)
            if (nums[i] > nums[(i + 1) % n]) {
                countDecreasing++;
            }
            // If more than one decreasing point is found, it's not a valid rotated sorted array
            if (countDecreasing > 1) {
                return false;
            }
        }

        return true;
    }
}
