class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length, n = heights[0].length;
        Set<List<Integer>> pacific = new HashSet<>();
        Set<List<Integer>> atlantic = new HashSet<>();

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++){
            dfs(i,0, pacific, heights[i][0], heights);
            dfs(i, n-1, atlantic, heights[i][n-1], heights);
        }

        for(int i = 0; i < n; i++){
            dfs(0,i, pacific, heights[0][i], heights);
            dfs(m-1, i,atlantic, heights[m-1][i], heights);
        }

        // return the intersection
        for(List<Integer> elem: pacific)
            if(atlantic.contains(elem))
                ans.add(elem);
        return ans;

    }
    private void dfs(int row, int col, Set<List<Integer>> visited, int prevHeight, int [][] heights){
        if(
            row < 0 || 
            col < 0 || 
            row == heights.length || 
            col == heights[0].length || 
            visited.contains(Arrays.asList(row, col)) || 
            heights[row][col] < prevHeight)   
            return;
        
        visited.add(Arrays.asList(row, col));

        // right
        dfs(row, col + 1, visited, heights[row][col], heights);
        // left
        dfs(row, col - 1, visited, heights[row][col], heights);
        // up
        dfs(row - 1, col, visited, heights[row][col], heights);
        // down
        dfs(row + 1, col, visited, heights[row][col], heights);
    }
}