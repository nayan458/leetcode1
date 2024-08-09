class Solution {
    // public boolean isPowerOfTwo(int n) {
    //     if(n == 0)
    //         return false;
    //     int x = (int)(Math.log(n) / Math.log(2));
    //     return Math.pow(2,x) == n;
    // }
    public boolean isPowerOfTwo(int n) {
        if(n <= 0)
            return false;
        return (n & (n-1)) == 0;
    }
}