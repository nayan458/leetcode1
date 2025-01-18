class Solution {
    public double myPow(double x, int n) {
        if(n==0)
            return 1;
        if(x == 0)
            return 0;
        long m = n;
        if(n<0){
            m = Math.abs((long)n);
            x=1/x;
        }
        double half= myPow(x,(int)(m/2));
        if(m%2==1)
            return x*half*half;
        return half* half;
    }
}


// class Solution {
//     public double myPow(double x, int n) {
//         long m = Math.abs(n);
//         if(n < 0)
//             x = 1/x;
//         while(m > 0){
//             x *= x;
//             --m;
//         }
//         return x;
//     }
// }


// class Solution {
//      public double myPow(double x, int n) {
//         long m = Math.abs((long)n); 
//         double result = 1.0;
//         double currentProduct = x;
//         while (m > 0) {
//             if (m % 2 == 1)
//                 result *= currentProduct;
//             currentProduct *= currentProduct;
//             m /= 2;
//         }
//         return n < 0 ? 1 / result : result;
//     }
//     // public double myPow(double x, int n) {
//     //     double ans;
//     //     if( n < 0)
//     //         x = 1/x;
//     //     if( n == 0) 
//     //         return 1;
//     //     if( Math.abs(n) == 1)
//     //         return x;
//     //     ans = myPow(x, Math.abs(n/2));
//     //     if(n%2 != 0)
//     //         return ans * ans * x;
//     //     return ans * ans;
//     // }
// }