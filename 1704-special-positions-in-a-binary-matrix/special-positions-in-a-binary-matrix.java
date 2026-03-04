class Solution {
    public int numSpecial(int[][] mat) {        
        Map<Integer,Integer> rowHm = new HashMap<>();
        Map<Integer,Integer> colHm = new HashMap<>();
        int count = 0;
        int m = mat.length;
        int n = mat[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1){
                    rowHm.put(i,rowHm.getOrDefault(i,0)+1);
                    colHm.put(j,colHm.getOrDefault(j,0)+1);
                }
            }
        }

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(mat[i][j] == 1){
                    if (rowHm.get(i) > 1 || colHm.get(j) > 1) continue;
                    count++;
                }
            }
        }
        return count;
    }
}