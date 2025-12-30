class Solution {
    public int numMagicSquaresInside(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;
        for(int i = 1; i < n-1; i++ ){
            for(int j = 1; j < m-1; j++){
                System.out.println(grid[i][j]);
                if(isMagicSquare(grid,i,j)){
                    count++;
                    System.out.println("count" + count);
                }
            }
        }
        return count;
    }

    private boolean isMagicSquare(int[][] grid, int i, int j){
        boolean flag = isSame(grid,i,j);
        System.out.println("flag: " + flag);
        if(flag) return false;
        int rowSum = getRowSum(grid,i,j);
        int colSum = getColSum(grid,i,j);
        int diagSum = getDiagSum(grid,i,j);
        System.out.println(rowSum + " " + colSum + " " + diagSum);
        return (rowSum == colSum && colSum == diagSum);
    }
    
    private int getRowSum(int[][] grid, int row, int col){
        int sti = row-1;
        int stj = col-1;
        int sum = -1;
        for(int i = 0; i < 3; i++){
            int curr_sum = 0;
            for(int j = 0; j < 3; j++){
                curr_sum += grid[sti+i][stj+j];
            }
            if(sum != -1 && curr_sum != sum) return -1;
            sum = curr_sum;
        }
        
        return sum;
    }
    private int getColSum(int[][] grid, int row, int col){
        int sti = row-1;
        int stj = col-1;
        int sum = -2;
        for(int i = 0; i < 3; i++){
            int curr_sum = 0;
            for(int j = 0; j < 3; j++){
                curr_sum += grid[sti+j][stj+i];
            }
            if(sum != -2 && curr_sum != sum) return -2;
            sum = curr_sum;
        }
        return sum;
    }
    private int getDiagSum(int[][] grid, int i, int j){
        int d1 = grid[i-1][j-1] + grid[i][j] + grid[i+1][j+1];
        int d2 = grid[i+1][j-1] + grid[i][j] + grid[i-1][j+1];

        return d1 == d2 ? d1 : -3;
    }
    private boolean isSame(int[][] grid, int row, int col){
        boolean[] visited = new boolean[10];
        for(int i = row-1; i < (row-1+3); i++){
            for(int j = col-1; j < (col-1+3); j++){
                System.out.print(grid[i][j] + " ");
                if(grid[i][j] <= 0 || grid[i][j] > 9 || visited[grid[i][j]]) return true;
                visited[grid[i][j]] = true;
            }
        }
        System.out.println();
        return false;
    }
}

// [
//     [3,2,9,2,7],
//     [6,1,8,4,2],
//     [7,5,3,2,7],
//     [2,9,4,9,6],
//     [4,3,8,2,5]
// ]