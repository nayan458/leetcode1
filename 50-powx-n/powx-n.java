class Solution {
     public double myPow(double x, int n) {
        long m = Math.abs((long)n); 
        double result = 1.0;
        double currentProduct = x;
        
        while (m > 0) {
            if (m % 2 == 1) {
                result *= currentProduct;
            }
            currentProduct *= currentProduct;
            m /= 2;
        }
        return n < 0 ? 1 / result : result;
    }
    // public double myPow(double x, int n) {
    //     double ans;
    //     if( n < 0)
    //         x = 1/x;
    //     if( n == 0) 
    //         return 1;
    //     if( Math.abs(n) == 1)
    //         return x;
    //     ans = myPow(x, Math.abs(n/2));
    //     if(n%2 != 0)
    //         return ans * ans * x;
    //     return ans * ans;
    // }
}