class DSU {
    private int[] parent;
    private int[] rank;

    public DSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];

        for(int i = 0; i < n; i++)
            parent[i] = i;
    }

    public int find(int u){
        if(u == parent[u])
            return u;
        return parent[u] = find(parent[u]);
    }

    public void union(int u, int v) {
        int parentOfU = find(u);
        int parentOfV = find(v);
        if(parentOfU == parentOfV) return;
        if(rank[parentOfU] < rank[parentOfV])
            parent[parentOfU] = parentOfV;
        else if(rank[parentOfU] > rank[parentOfV])
            parent[parentOfV] = parentOfU;
        else {
            parent[parentOfV] = parentOfU;
            rank[parentOfU]++;
        }
    }

}

class Solution {
    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        int hammingDistance = 0;
        DSU dsu = new DSU(n);
        createParentMaping(dsu, allowedSwaps);

        Map<Integer, List<Integer>> groupByParent = new HashMap<>();

        for(int i = 0; i < n; i++)
            groupByParent.computeIfAbsent(dsu.find(i), k -> new ArrayList<>()).add(i);

        for(List<Integer> group: groupByParent.values()){
            Map<Integer, Integer> freq = new HashMap<>();
            for(int idx: group)
                freq.put(source[idx],freq.getOrDefault(source[idx], 0) + 1);
            
            for(int idx: group) {
                if(freq.getOrDefault(target[idx],0) > 0)
                    freq.put(target[idx], freq.get(target[idx]) - 1);
                else
                    hammingDistance++;
            }
        }

        return hammingDistance;       
    }

    private void createParentMaping(DSU dsu, int[][] edges) {
        for(int[] edge: edges) {
            int u = edge[0], v = edge[1];
            dsu.union(u,v);
        }
    }
}