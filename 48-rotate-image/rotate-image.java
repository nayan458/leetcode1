class Solution {
    public void rotate(int[][] matrix) {
        // transpose
        for( int i = 0; i < matrix.length; i ++){
            for( int j = i+1; j < matrix.length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        int temp = matrix[0][0];
        for( int i = 0; i < matrix.length; i++){
            int l=0,r=matrix[i].length-1;
            while(l<=r){
                int yz = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = yz;
                l++;
                r--;
            }
        }
    }
}