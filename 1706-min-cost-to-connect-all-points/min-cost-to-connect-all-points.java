class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        PriorityQueue<int[]> distance = new PriorityQueue<>(
            (a,b) -> a[0] - b[0]
        );

        int[] parent = new int[n];

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
            int u = elem[1], v = elem[2], p_u = parent[u], p_v = parent[v];
            while(parent[p_v] != p_v)
                p_v = parent[p_v];
            while(parent[p_u] != p_u)
                p_u = parent[p_u];
            if(p_u == p_v) continue;
            parent[p_u] = p_v;
            n -= 1;
            min += elem[0];
        }

        return min;

    }
}