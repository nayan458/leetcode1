class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length, m = matrix.length;
        int i = 0, j = n - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target)
                return true;
            if(matrix[i][j] <= target)
                i++;
            else
                j--;
        }
        return false;
    }
}