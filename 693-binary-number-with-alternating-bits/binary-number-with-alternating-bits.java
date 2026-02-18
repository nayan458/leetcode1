class Solution {
    public boolean hasAlternatingBits(int n) {
        boolean flag = !((n&1) == 0);
        while(n != 0) {
            if(!(((n & 1) == 0) ^ flag))
                return false;
            flag = !flag;
            n = n >> 1;
        }
        return true;
    }
}