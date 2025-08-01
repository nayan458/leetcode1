class Solution {
    int[] parent;

    public int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]); // Path compression
        return parent[x];
    }

    public boolean union(int u, int v) {
        int pu = find(u);
        int pv = find(v);
        if (pu == pv)
            return false; // u and v are already connected → cycle
        parent[pu] = pv;
        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];

        // Initialize each node as its own parent
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int[] edge : edges) {
            if (!union(edge[0], edge[1])) {
                return edge; // Found the cycle
            }
        }

        return new int[0]; // Should not reach here
    }
}