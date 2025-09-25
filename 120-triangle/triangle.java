class Solution {
    int n;
    int m;
    int[][] t;
    boolean[][] visited;

    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        m = triangle.get(n-1).size();
        t = new int[n + 1][m + 1];
        visited = new boolean[n + 1][m + 1];
        return dfs(triangle, 0, 0);
    }

    private int dfs(List<List<Integer>> triangle, int i, int j){
        if(i == n)
            return 0;
        if(visited[i][j])
            return t[i][j];

        visited[i][j] = true;
        return t[i][j] = triangle.get(i).get(j) + Math.min( 
            dfs(triangle, i+1, j), 
            dfs(triangle, i+1, j+1)
            );
    }
}
