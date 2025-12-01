class Solution {
    public long maxRunTime(int n, int[] batteries) {
        long total_sum = sum(batteries);
        if(n == 1) return total_sum;

        long left = 0, right = total_sum;

        while(left < right) {
            long mid = left + (right - left + 1) / 2;
            if(canEffort(mid,n,batteries)) left = mid;
            else right = mid - 1;
        }
        return left;
    }

    private boolean canEffort(long T,int n, int[] nums) {
        long total = 0;
        for(int elem: nums)
            total += Math.min(elem, T);
        return total >= (1L * T * n);
    }

    private long sum(int[] nums) {
        long total = 0;
        for(int elem: nums)
            total += (long) elem;
        return total;
    }
}