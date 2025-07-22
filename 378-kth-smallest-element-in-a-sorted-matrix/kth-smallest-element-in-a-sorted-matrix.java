// Approach II: Binary Search
// Time Complexity O(NlogN)
// Space Complexity O(1)
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0], right = matrix[n - 1][n - 1];
        int mid;

        while(left < right){
            mid = left + (right - left)/2;
            int count = countEquals(matrix, mid, n);
            if(count < k)
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }

    private int countEquals(int[][] matrix, int target, int n){
        int count = 0;
        int row = n - 1, col = 0;

        while(row >= 0 && col < n){
            if(matrix[row][col] <= target){
                count += (row + 1);
                col++;
            } else {
                row--;
            }
        }

        return count;
    }
}

// Approach I: Heap approach
// Time Complexity: O(n^2)
// Space Complexity: O(k) O(n^2)
// class Solution {
//     public int kthSmallest(int[][] matrix, int k) {
//         PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
//         int n = matrix.length;
//         if(k == n*n)
//             return matrix[n - 1][n - 1];
//         if(k == 1)
//             return matrix[0][0];
//         for(int i = 0; i < n; i ++){
//             for(int j = 0; j < n; j++){
//                 if((i * n) + (j + 1) <= k){
//                     heap.add(matrix[i][j]);
//                     continue;
//                 }
//                 if(matrix[i][j] < heap.peek()){
//                     heap.poll();
//                     heap.add(matrix[i][j]);
//                 }
//             }
//         }
//         // while(--k > 1)
//         //     heap.poll();
//         return heap.poll();
//     }
// }