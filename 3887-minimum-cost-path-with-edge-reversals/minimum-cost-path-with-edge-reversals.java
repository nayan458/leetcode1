class Solution {

    public int minCost(int n, int[][] edges) {
        List<List<int[]>> adjList = createGraph(edges,n);
        return dijkstra(adjList,0,n-1);
    }

    Comparator<int[]> CMP = (a, b) -> a[0] - b[0];

    private int dijkstra(List<List<int[]>> adjList, int source, int target) {
        int n = adjList.size();
        int[] costs = new int[n];
        Arrays.fill(costs,Integer.MAX_VALUE);
        costs[source]=0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        boolean[] visited = new boolean[n];

        heap.offer(new int[]{0,source});

        while(!heap.isEmpty()){
            int[] vertex = heap.poll();
            int curr_cost = vertex[0];
            int node = vertex[1];
            
            if(visited[node])   continue;
            visited[node] = true;
            
            if(node == target)  return curr_cost;

            for(int[] neighbor: adjList.get(node)){
                int u = neighbor[0];
                int cost = neighbor[1] + curr_cost;
                if(visited[u]) continue;
                costs[u] = cost;
                heap.offer(new int[]{cost,u});
            }
        }

        return visited[target] ? costs[target] : -1;
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