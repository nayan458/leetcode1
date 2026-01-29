class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long[][] minCost = getMinCost(original,changed,cost);
        long total = 0;
        for(int i = 0; i < source.length(); i++){
            int sch = Integerize(source.charAt(i));
            int tch = Integerize(target.charAt(i));
            if(sch == tch) continue;
            if( minCost[sch][tch] == Long.MAX_VALUE ) return -1;
            total += minCost[sch][tch];
        }
        return total;
    }

    private long[][] getMinCost(char[] uNode, char[] vNode, int[] cost){
        List<List<int[]>> adjList = createAdjList(uNode,vNode,cost);
        long[][] minCost = new long[26][26];
        
        for(int i = 0; i < 26; i++)
            minCost[i] = Dijkstra(adjList,i);
        
        return minCost;
    }

    private long[] Dijkstra(List<List<int[]>> adjList, int src) {
        long[] minCost = new long[26];
        boolean[] visited = new boolean[26];

        Arrays.fill(minCost, Long.MAX_VALUE);
        minCost[src] = 0;

        PriorityQueue<long[]> heap =
                new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));

        heap.offer(new long[]{src, 0});

        while (!heap.isEmpty()) {
            long[] node = heap.poll();
            int u = (int) node[0];
            long cost = node[1];

            if (visited[u]) continue;
            visited[u] = true;

            for (int[] edge : adjList.get(u)) {
                int v = edge[0];
                int w = edge[1];

                if (visited[v]) continue;

                if (cost + w < minCost[v]) {
                    minCost[v] = cost + w;
                    heap.offer(new long[]{v, minCost[v]});
                }
            }
        }

        return minCost;
    }

    private List<List<int[]>> createAdjList(char[] uNode, char[] vNode, int[] cost){
        List<List<int[]>> adjList = new ArrayList<>();
        
        for(int i = 0; i < 26; i++)
            adjList.add(new ArrayList<>());
        
        for(int i = 0; i < uNode.length; i++){
            int u = Integerize(uNode[i]);
            int v = Integerize(vNode[i]);
            int c = cost[i];
            adjList.get(u).add(new int[]{v,c});
        }

        return adjList;
    }

    private int Integerize(char ch){
        return (int) (ch - 'a');
    }
}
