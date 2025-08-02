class Solution {
    public int findCenter(int[][] edges) {
        int u = edges[0][0];
        int v = edges[0][1];

        for(int i = 1; i < 3; i++){
            if(edges[i][0] == u)
                return u;
            if(edges[i][1] == u)
                return u;
            if(edges[i][0] == v)
                return v;
            if(edges[i][1] == v)
                return v;
        }

        return v;
    }
}