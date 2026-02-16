class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for(int i = 0; i < 32; i++) {
            int bit = ((n & (1 << i)) == 0 ? 0 : 1);
            result += bit * (int)Math.pow(2,31-i);
        }
        return result;
    }
}