class Solution {
    public int binaryGap(int n) {
        int maxGap = 0;
        
        while (n > 0 && (n & 1) == 0) {
            n >>= 1;
        }

        int count = 0;

        while (n > 0) {
            n >>= 1;
            count++;

            if ((n & 1) == 1) {
                maxGap = Math.max(maxGap, count);
                count = 0;
            }
        }

        return maxGap;
    }
}