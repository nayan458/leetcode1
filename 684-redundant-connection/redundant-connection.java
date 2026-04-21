class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = java.util.stream.IntStream
                        .rangeClosed(0,1001)
                        .toArray();

        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            int parentOfU = parent[u], parentOfV = parent[v];
            while(parentOfU != parent[parentOfU])
                parentOfU = parent[parentOfU];
            while(parentOfV != parent[parentOfV])
                parentOfV = parent[parentOfV];
            if(parentOfU != parentOfV)
                parent[parentOfU] = parentOfV;
            else
                return edge;
        }

        return new int[0];
    }
}