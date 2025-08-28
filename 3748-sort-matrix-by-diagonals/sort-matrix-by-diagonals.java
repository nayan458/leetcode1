class Solution {

    public int[][] sortMatrix(int[][] grid) {
        PriorityQueue<Integer> ls;
        int m = grid.length;
        int n = grid[0].length;

        // System.out.println("top");
        for(int i = 1; i < n; i++){
            int row = 0;
            int col = i;

            ls = new PriorityQueue<>(
                (a,b) -> b - a
            );

            while(row >= 0 && row < m && col >= 0 && col < n)
                ls.add(grid[row++][col++]);

            while(!ls.isEmpty())
                grid[--row][--col] = ls.poll();
        }

        // System.out.println("bottom");
        for(int i = 0; i < n; i++){
            int row = i;
            int col = 0;

            ls = new PriorityQueue<>(
                (a,b) -> a -b
            );

            while(row < m && col < n)
                ls.add(grid[row++][col++]);

            while(!ls.isEmpty())
                grid[--row][--col] = ls.poll();
        }
        return grid;
    }
}