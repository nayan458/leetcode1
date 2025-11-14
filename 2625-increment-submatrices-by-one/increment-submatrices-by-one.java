class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int [n+1][n+1];

        for(int[] query: queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            diff[row1][col1] += 1;
            diff[row2+1][col1] -= 1;
            diff[row1][col2+1] -= 1;
            diff[row2+1][col2+1] += 1;
        }

        int[][] grid = new int [n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = (i == 0) ? 0 : grid[i - 1][j];
                int x2 = (j == 0) ? 0 : grid[i][j - 1];
                int x3 = (i == 0 || j == 0) ? 0 : grid[i - 1][j - 1];
                grid[i][j] = diff[i][j] + x1 + x2 - x3;
            }
        }
        return grid;
    }
}

// class Solution {
//     public int[][] rangeAddQueries(int n, int[][] queries) {
//         int[][] grid = new int [n][n];

//         for(int[] query: queries) {
//             int row1 = query[0]; 
//             int col1 = query[1];
//             int row2 = query[2];
//             int col2 = query[3];
//             for(int i = row1; i <= row2; i++)
//                 for(int j = col1; j <= col2; j++)
//                     grid[i][j]++;
//         }

//         return grid;
//     }
// }