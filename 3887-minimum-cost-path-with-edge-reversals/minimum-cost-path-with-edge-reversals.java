class Solution {

    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adjList = createGraph(edges,n);
        return dijkstra(adjList,0,n-1);
    }

    Comparator<int[]> CMP = (a, b) -> a[0] - b[0];

    private int dijkstra(List<List<int[]>> adjList, int source, int target) {
        int n = adjList.size();
        boolean[] visited = new boolean[n];
        int[] cost = new int[n];
        Arrays.fill(cost, Integer.MAX_VALUE);

        PriorityQueue<int[]> heap = new PriorityQueue<>(CMP);

        cost[source] = 0;
        heap.offer(new int[]{0, source});

        while (!heap.isEmpty()) {
            int[] cur = heap.poll();
            int currCost = cur[0];
            int u = cur[1];

            if (visited[u]) continue;
            visited[u] = true;

            if (u == target) return currCost;

            for (int[] edge : adjList.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (!visited[v] && currCost + w < cost[v]) {
                    cost[v] = currCost + w;
                    heap.offer(new int[]{cost[v], v});
                }
            }
        }

        return cost[target] == Integer.MAX_VALUE ? -1 : cost[target];
    }

    private List<List<int[]>> createGraph(int[][] edges, int n) {
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];
            int cost = edge[2];

            adjList.get(u).add(new int[]{v,cost});
            adjList.get(v).add(new int[]{u,cost*2});
        }
        return adjList;
    }
}