class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix[0].length, m = matrix.length;
        for(int i = 0; i < m; i++){
            if(matrix[i][n - 1] == target)
                return true;
            if(matrix[i][n - 1] < target)
                continue;
            else
                return binarySearch(matrix[i], target);
        }
        return false;
    }

    private boolean binarySearch(int[] arr, int target){
        int left = 0, right = arr.length - 1;
        int mid = left + ((right - left)/2);
        while(left < right){
            if(arr[mid] == target)
                return true;
            if(arr[mid] < target)
                left = mid + 1;
            else 
                right = mid - 1;
            mid = left + ((right - left)/2);
        }
        if(arr[mid] == target)
            return true;
        return false;
    }
}