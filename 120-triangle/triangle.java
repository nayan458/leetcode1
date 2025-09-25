class Solution {
    int n;
    int m;
    int[][] t;

    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        m = triangle.get(n-1).size();
        t = new int[n + 1][m + 1];
        int min = Integer.MAX_VALUE;

        if(n == 1)
            return triangle.get(0).get(0);

        t[0][0] = triangle.get(0).get(0);

        for(int i = 1; i < n; i++){
            int curr_m = i + 1;
            for(int j = 0; j < curr_m; j++){
                if(j == curr_m - 1)
                    t[i][j] = triangle.get(i).get(j) + t[i - 1][j - 1];
                else if(j == 0)
                    t[i][j] = triangle.get(i).get(j) + t[i - 1][j];
                else
                    t[i][j] = triangle.get(i).get(j) + Math.min( t[i - 1][j - 1], t[i - 1][j]);
                if(i == m - 1)
                    min = Math.min(t[i][j], min);
            }
        }

        return min;
    }

    // private int dfs(List<List<Integer>> triangle, int i, int j){
    //     if(i == n)
    //         return 0;
    //     if(visited[i][j])
    //         return t[i][j];

    //     visited[i][j] = true;
    //     return t[i][j] = triangle.get(i).get(j) + Math.min( 
    //         dfs(triangle, i+1, j), 
    //         dfs(triangle, i+1, j+1)
    //         );
    // }

    // t[0][0] = triangle[0][0];

    // for(int i = 1; i < n; i++){
    //     int curr_m = Math.pow(2,i);
    //     for(int j = 0; j < curr_m; j++){
    //         if(j == curr_m)
    //             t[i][j] = triangle[i][j] + t[i - 1][j - 1];
    //         if(j == 0)
    //             t[i][j] = triangle[i][j] + t[i - 1][j];
    //         else
    //             t[i][j] = triangle[i][j] + Math.min( t[i - 1][j - 1], t[i - 1][j]);
    //     }
    // }

    // return t[m + 1][n + n];
}
