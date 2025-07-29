class Solution {
    public int minimumEffortPath(int[][] heights) {
        // heap or balance BST with the following structure
        // [ [difference, row, col] ]
        int m = heights.length;
        int n = heights[0].length;
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[0],b[0])
        );

        boolean[] visited = new boolean[m*n]; // visited array of [row, col]
        heap.add(new int[]{0, 0, 0});

        while(!heap.isEmpty()){
            int[] node = heap.poll();
            int row = node[1];
            int col = node[2];
            int diff = node[0];
            int index = (row * n) + col;

            if(index == ((m - 1) * n + (n - 1))) return diff;
            if(visited[index]) continue;
            visited[index] = true;
            
            int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
            for (int[] dir : directions) {
                int dr = dir[0];
                int dc = dir[1];
                int newRow = row + dr, newCol = col + dc;
                index = (newRow * n) + newCol;
                if(newRow < 0 || newRow >= m || newCol < 0 || newCol >= n || visited[index])
                    continue;

                int newDiff = Math.max(diff,Math.abs(heights[row][col] - heights[newRow][newCol]));
                heap.add(new int[]{newDiff, newRow, newCol});
            }
        }   
        return 0;
    }
}