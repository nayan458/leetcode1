class Solution {
    int size, m, n;

    public int[] findDiagonalOrder(int[][] mat) {
        m = mat.length;
        n = mat[0].length; // common difference
        size = m * n;

        int[] ans = new int[size];
        int k = 0;
        List<Integer> ls = new ArrayList<>();
        
        for(int d = 0; d < (m+n-1); d++){
            ls = new ArrayList<>();
            for(int row = 0; row < m; row++){
                int col = d - row;
                if (col < 0) break;
                if (col >= n) continue;
                ls.add(mat[row][col]);
            }
            if(d % 2 == 0){
                Collections.reverse(ls);
            }
            for(int elem: ls)
                ans[k++] = elem;
        }

        return ans;
    }
}