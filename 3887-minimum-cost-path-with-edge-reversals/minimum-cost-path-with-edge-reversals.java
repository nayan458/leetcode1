class Solution {
    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adjList = creategraph(edges, n);
        return dijkstra(adjList, n);
    }

    private List<List<int[]>> creategraph(int[][] edges, int n){
        List<List<int[]>> adjList = new ArrayList<>();

        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        
        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adjList.get(u).add(new int[]{v, w});
            adjList.get(v).add(new int[]{u, w * 2});
        }
        
        return adjList;
    }

    private int dijkstra(List<List<int[]>> adjList, int n){
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b) -> a[1] - b[1] // min-heap on distance
        );
        
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);
        cost[0] = 0; // distance to source = 0

        heap.add(new int[]{0, 0}); // {node, distance}

        while(!heap.isEmpty()){
            int[] elem = heap.poll();
            int u = elem[0];
            int weight = elem[1];

            if(weight > cost[u]) continue; // skip outdated entry

            for(int[] neighbour: adjList.get(u)){
                int v = neighbour[0];
                int d = neighbour[1]; // edge weight

                if(cost[u] + d < cost[v]){  // relaxation step
                    cost[v] = cost[u] + d;
                    heap.add(new int[]{v, cost[v]});
                }
            }
        }

        return cost[n - 1] == Integer.MAX_VALUE ? -1 : cost[n - 1];
    }
}
