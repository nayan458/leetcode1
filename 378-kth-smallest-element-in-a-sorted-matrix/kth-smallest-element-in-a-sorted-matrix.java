class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        int n = matrix.length;
        if(k == n*n)
            return matrix[n - 1][n - 1];
        if(k == 1)
            return matrix[0][0];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < n; j++){
                if((i * n) + (j + 1) <= k){
                    heap.add(matrix[i][j]);
                    continue;
                }
                if(matrix[i][j] < heap.peek()){
                    heap.poll();
                    heap.add(matrix[i][j]);
                }
            }
        }
        // while(--k > 1)
        //     heap.poll();
        return heap.poll();
    }
}