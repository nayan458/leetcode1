class Solution {
    int n;
    int m;
    int[] t;

    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        m = triangle.get(n-1).size();
        int size = (m * (1 + m))/2;
        t = new int[size];

        if(n == 1)
            return triangle.get(0).get(0);

        // initialization
        for(int i = 0; i < m; i++)
            t[i+size-m] = triangle.get(n - 1).get(i);

        for(int i = n-2; i >= 0; i--){
            int start = (i * (1 + i))/2;
            int match = start + i + 1;

            for(int j = 0; j < i+1; j++){
                t[start++] = triangle.get(i).get(j) + Math.min(t[match],t[match+1]);
                match++;
            }
        }

        return t[0];
    }
}

// class Solution {
//     int n;
//     int m;
//     int[][] t;

//     public int minimumTotal(List<List<Integer>> triangle) {
//         n = triangle.size();
//         m = triangle.get(n-1).size();
//         t = new int[n + 1][m + 1];
//         int min = Integer.MAX_VALUE;

//         if(n == 1)
//             return triangle.get(0).get(0);

//         t[0][0] = triangle.get(0).get(0);

//         for(int i = 1; i < n; i++){
//             int curr_m = i + 1;
//             for(int j = 0; j < curr_m; j++){
//                 if(j == curr_m - 1)
//                     t[i][j] = triangle.get(i).get(j) + t[i - 1][j - 1];
//                 else if(j == 0)
//                     t[i][j] = triangle.get(i).get(j) + t[i - 1][j];
//                 else
//                     t[i][j] = triangle.get(i).get(j) + Math.min( t[i - 1][j - 1], t[i - 1][j]);
//                 if(i == m - 1)
//                     min = Math.min(t[i][j], min);
//             }
//         }

//         return min;
//     }
// }
