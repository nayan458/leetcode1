class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0;
        long min = 100_001;
        int count = 0;

        for(int[] row: matrix){
            for(int elem: row){
                if(elem < 0)
                    count = (count + 1) % 2;
                sum += (Math.abs(elem) * 1L);
                min = Math.min(min,Math.abs(elem));
            }
        }

        return count == 0 ? sum : sum - min - min;
    }
}