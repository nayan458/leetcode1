class Solution{
    public int gcdOfOddEvenSums(int n){
        return n;
    }
}
// class Solution {
//     public int gcdOfOddEvenSums(int n) {
//         int sumOdd = (n * (1 + (2 * n) - 1))/2;
//         int sumEven = (n * (2 + (2 * n)))/2;
//         return gcd(sumOdd, sumEven);
//     }
    
//     private int gcd(int a, int b) {
//         while (b != 0) {
//             int temp = b;
//             b = a % b;  // remainder
//             a = temp;
//         }
//         return a;
//     }
// }