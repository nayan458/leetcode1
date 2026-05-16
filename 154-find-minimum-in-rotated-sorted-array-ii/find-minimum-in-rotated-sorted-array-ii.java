class Solution {
    public int findMin(int[] nums) {
        int min = 5001;
        for(int elem: nums)
            min = Math.min(elem,min);
        return min;
    }
}