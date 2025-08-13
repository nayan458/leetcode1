class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0){
            return false;
        }
        while(n%3 == 0){
            n /= 3;
        }
        if(n == 1){
            return true;
        }
        return false;
    }
}

// class Solution {
    
//     public boolean isPowerOfThree(int n) {
//         if(n <= 0)
//             return false;
//         while(n % 3 == 0){
//             n /= 3;
//         }
//         return n == 1 || n == 3;
//     }
// }

// class Solution {
//     private static final int[] threePower = {1, 3, 9, 27, 81, 243, 729, 2187, 6561, 19683,59049, 177147, 531441, 1594323, 4782969,14348907, 43046721, 129140163, 387420489, 1162261467};

    
//     public boolean isPowerOfThree(int n) {
//         if(n <= 0)
//             return false;

//         int left = 0, right = 19;
        
//         while(left <= right){
//             int mid = left + (right - left)/2;
//             int ans = threePower[mid];
//             if(ans == n)
//                 return true;
//             if(ans < n)
//                 left = mid + 1;
//             else
//                 right = mid - 1;
//         }
//         return false;
//     }


// }