class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int l = 0, r = (m * n) - 1;

        while(l <= r){
            int mid = l + (r - l)/2;
            int i = mid / n, j = mid % n;
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] < target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        
        return false;
    }
}
// class Solution {
//     public boolean searchMatrix(int[][] matrix, int target) {
//         int n = matrix[0].length, m = matrix.length;
//         int l = 0, r = m - 1;
//         int mid = 0, m_index = r;

//         // Optimized Solution:
//         // Time complexity: O(log(m) * log(n)) 
//         while(l <= r){
//             mid = l + ((r - l)/2);
//             if(matrix[mid][n - 1] == target)
//                 return true;
//             if(matrix[mid][n - 1] < target)
//                 l = mid + 1;
//             else{
//                 m_index = Math.min(m_index, mid);
//                 r = mid - 1;
//             }
//         }

//         return binarySearch(matrix[m_index], target);

//         // Time Complexity: O(m * logn)
//         // for(int i = 0; i < m; i++){
//         //     if(matrix[i][n - 1] == target)
//         //         return true;
//         //     if(matrix[i][n - 1] < target)
//         //         continue;
//         //     else
//         //         return binarySearch(matrix[i], target);
//         // }
//         // return false;
//     }

//     // private boolean binarySearchIndex(int[] arr)

//     private boolean binarySearch(int[] arr, int target){
//         int left = 0, right = arr.length - 1;
//         int mid;
//         while(left <= right){
//             mid = left + ((right - left)/2);
//             if(arr[mid] == target)
//                 return true;
//             if(arr[mid] < target)
//                 left = mid + 1;
//             else 
//                 right = mid - 1;
//         }
//         return false;
//     }
// }