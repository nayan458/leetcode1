class Solution {
    private int k;
    private int[] values;
    private boolean[] visited;
    private int count;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        this.visited = new boolean[n];
        this.count = 0;

        List<List<Integer>> adjList = createAdj(edges, n);
        dfs(adjList, 0, -1);
        return count;
    }
    private int dfs(List<List<Integer>> adjList, int node, int parent) {
        if(parent == node)
            return 0;
        
        int sum = values[node];

        for(int neighbor: adjList.get(node)){
            if(neighbor != parent)
                sum = ((sum % k) + (dfs(adjList, neighbor, node) % k)) % k;
        }

        if(sum % k == 0){
            count++;
            return 0;
        }

        return sum % k;
    }

    private List<List<Integer>> createAdj(int[][] edges, int n){
        List<List<Integer>> adjList = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adjList.get(u).add(v);
            adjList.get(v).add(u);
        }

        return adjList;
    }
}