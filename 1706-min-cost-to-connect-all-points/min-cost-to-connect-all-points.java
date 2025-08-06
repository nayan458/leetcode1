class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> distance = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        int[] parent = new int[n];
        int[] rank = new int[n];

        for(int i = 0; i < n; i++){
            parent[i] = i;
            for(int j = i + 1; j < n; j++){
                int dist = Math.abs(points[i][0] - points[j][0]) + Math.abs(points[i][1] - points[j][1]);
                distance.add(new int[]{dist, i, j});
            }
        }

        int min = 0;
        while(n > 1){
            int[] elem = distance.poll();
            int u = elem[1], v = elem[2];
            int p_u = find(u, parent), p_v = find(v, parent);
            
            if(p_u == p_v) continue;
            if (rank[p_u] < rank[p_v]) {
                parent[p_u] = p_v;
            } else if (rank[p_u] > rank[p_v]) {
                parent[p_v] = p_u;
            } else {
                parent[p_v] = p_u;
                rank[p_u]++;
            }
            n -= 1;
            min += elem[0];
        }

        return min;

    }
    private int find(int x, int[] parent){
        if(parent[x] == x)
            return x;
        return parent[x] = find(parent[x], parent);
    }
}