class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        transpose(matrix);

        System.out.println(Arrays.deepToString(matrix));

        for(int[] row: matrix)
            reverse(row);
    }

    void reverse(int[] row) {
        
        int n = row.length;

        for(int i = 0; i < n/2; i++) {
            int temp = row[i];
            row[i] = row[n-i-1];
            row[n-i-1] = temp;            
        }
        
    }

    void transpose(int[][] matrix) {
        int n = matrix.length;

        for(int i = 0; i < n; i++) 
            for(int j = 0+i; j < n; j++)
                swap(i,j,matrix);

    }

    void swap(int i, int j, int[][] matrix) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
}