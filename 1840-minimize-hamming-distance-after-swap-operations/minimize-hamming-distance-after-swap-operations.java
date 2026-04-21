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
        DSU dsu = new DSU(n);
        createParentMaping(dsu, allowedSwaps);

        Map<Integer, Set<Integer>> sourceElemIdx = new HashMap<>();
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i = 0; i < n; i++){
            if(source[i] == target[i]) continue;
            sourceElemIdx.computeIfAbsent(source[i], k -> new HashSet<>()).add(i);
        }

        int hammingDistance = 0;

        for(int i = 0; i < n; i++){
            if(source[i] != target[i]){
                boolean flag = false;

                if(sourceElemIdx.containsKey(target[i]) && sourceElemIdx.get(target[i]).size() > 0)
                    for(int idx: sourceElemIdx.get(target[i]))
                        if(dsu.find(i) == dsu.find(idx)) {
                            sourceElemIdx.get(target[i]).remove(idx);
                            flag = true;
                            break;
                        }
                if(!flag) hammingDistance++;
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