class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] diff = new int [n][n];
        int[][] grid = new int [n][n];

        for(int[] query: queries) {
            int row1 = query[0];
            int col1 = query[1];
            int row2 = query[2];
            int col2 = query[3];

            // topLeft
            diff[row1][col1] += 1;

            // top right + 1 step right
            if(col2 + 1 < n)
                diff[row1][col2+1] -= 1;

            // bottomLeft + 1 step down
            if(row2 + 1 < n)
                diff[row2+1][col1] -= 1;

            // bottom right + 1 step down + 1 step right
            if(row2 + 1 < n && col2 + 1 < n)
                diff[row2+1][col2+1] += 1;
        }
        int top = 0;
        int left = 0;
        int topRightCorner = 0;

        for(int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                top = getTop(grid,i,j);
                left = getLeft(grid,i,j);
                topRightCorner = getTopRightCorner(grid,i,j);
                grid[i][j] = diff[i][j] + top + left - topRightCorner;
            }
        }
        return grid;
    }
    private int getTopRightCorner(int[][] grid, int i, int j) {
        if(i == 0 || j == 0) 
            return 0;
        return grid[i-1][j-1];
    }
    private int getTop(int[][] grid, int i, int j) {
        if(i == 0)
            return 0;
        return grid[i-1][j];
    }

    private int getLeft(int[][] grid, int i, int j) {
        if(j == 0)
            return 0;
        return grid[i][j-1];
    }

    private void print(int grid[][]) {
        for(int[] row: grid) {
            for(int elem: row) {
                System.out.print(elem + " ");
            }
            System.out.println();
        }
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