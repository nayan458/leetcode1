class Solution {
    private static int count;

    static {
        int n = 5;
        int[][] edges = {{0,2},{1,2},{1,3},{2,4}}; 
        int[] values = {1,8,1,4,4};
        int k = 6;
        for(int i = 0; i < 500; i++)
            maxKDivisibleComponents(n, edges, values, k);
    }
    
    public static int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        count = 0;
        List<List<Integer>> adjList = createAdj(edges, n);
        dfs(adjList, 0, -1, k, values);
        return count;
    }

    private static int dfs(List<List<Integer>> adjList, int node, int parent, int k, int[] values) {
        if(parent == node)
            return 0;    
        int sum = values[node];
        for(int neighbor: adjList.get(node)){
            if(neighbor != parent)
                sum = ((sum % k) + (dfs(adjList, neighbor, node, k, values) % k)) % k;
        }
        if(sum % k == 0){
            count++;
            return 0;
        }
        return sum % k;
    }

    private static List<List<Integer>> createAdj(int[][] edges, int n){
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