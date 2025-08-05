class Solution {

    int[] parent;

    public int findP(int node){
        if(parent[node] == node)
            return node;
        return parent[node] = findP(parent[node]);
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length + 1;
        parent = new int[n];
        for(int i = 0; i < n; i++)
            parent[i] = i;
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int p_u = findP(parent[u]);
            int p_v = findP(parent[v]);

            if(p_u == p_v)
                return edge;
            parent[p_u] = p_v;
        }
        return new int[] {0,0};
    }
}