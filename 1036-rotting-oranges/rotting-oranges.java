class Solution {

    class orangeDto {
        int row, col, time;

        public orangeDto(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public int orangesRotting(int[][] grid) {
        int fo = 0; // fresh oranges
        Queue<orangeDto> q = new LinkedList<>();
        int row = grid.length, col = grid[0].length;
        int time = 0;

        for(int i = 0; i < row; i++)
            for(int j = 0; j < col; j++) {
                if(grid[i][j] == 2) {
                    orangeDto orange = new orangeDto(i, j, 0);
                    q.add(orange);
                    continue;
                }
                if( grid[i][j] == 1) 
                    ++fo;
            }


        
        // while stack is not empty
        while(!q.isEmpty()) {
            orangeDto orange = q.remove();
            if(orange.time > time)
                time = orange.time;
            // check top
            if((orange.row - 1) >= 0 && grid[orange.row - 1][orange.col] == 1 ) {
                grid[orange.row - 1][orange.col] = 2;
                q.add( new orangeDto((orange.row - 1), orange.col, (orange.time + 1)) );
                --fo;
            }

            // check bottom

            if((orange.row + 1) < row && grid[orange.row + 1][orange.col] == 1 ) {
                grid[orange.row + 1][orange.col] = 2;
                q.add(new orangeDto((orange.row + 1), orange.col, (orange.time + 1)));
                --fo;
            }

            // chech right

            if((orange.col + 1) < col && grid[orange.row][orange.col + 1] == 1 ) {
                grid[orange.row][orange.col + 1] = 2;
                q.add(new orangeDto(orange.row, (orange.col + 1), (orange.time + 1)));
                --fo;
            }

            // check left

            if((orange.col - 1) >= 0 && grid[orange.row][orange.col - 1] == 1 ) {
                grid[orange.row][orange.col - 1] = 2;
                q.add(new orangeDto(orange.row, (orange.col - 1), (orange.time + 1)));
                --fo;
            }
        }

        if(!q.isEmpty()) {
            orangeDto orange = q.remove();

            if(time < orange.time)
                time = orange.time;
        }

        return (fo != 0 ) ? -1 : time;
    }
}