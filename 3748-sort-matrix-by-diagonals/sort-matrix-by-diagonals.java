class Solution {

    public int[][] sortMatrix(int[][] grid) {
        List<Integer> ls;
        int m = grid.length;
        int n = grid[0].length;

        // System.out.println("top");
        for(int i = 1; i < n; i++){
            int row = 0;
            int col = i;

            ls = new ArrayList<>();

            while(row >= 0 && row < m && col >= 0 && col < n){
                // System.out.println(row + " " + col);
                ls.add(grid[row][col]);
                row += 1;
                col += 1;
            }
            Collections.sort(ls);

            // row,col
            row = 0; col = i;
            for(Integer elem: ls)
                grid[row++][col++] = elem;
        }

        // System.out.println("bottom");
        for(int i = 0; i < n; i++){
            int row = i;
            int col = 0;

            ls = new ArrayList<>();

            while(row < m && col < n){
                // System.out.println(row + " " + col);
                ls.add(grid[row][col]);
                row += 1;
                col += 1;
            }
            Collections.sort(ls);

            for(Integer elem: ls)
                grid[--row][--col] = elem;
        }
        return grid;
    }
}