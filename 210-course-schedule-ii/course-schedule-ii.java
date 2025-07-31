class Solution {
    Set<Integer> courseSchedule = new LinkedHashSet<>();
    private Map<Integer, Set<Integer>> hm = new HashMap<>();
    private Set<Integer> waiting = new HashSet<>();

    public int[] findOrder(int n, int[][] edges) {
        List<List<Integer>> adjList = createGraph(edges, n);
        System.out.println(hm);

        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i])
                if (dfs(i, adjList, visited))
                    return new int[0];
        }

        List<Integer> result = new ArrayList<>(courseSchedule);
        Collections.reverse(result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean dfs(int node, List<List<Integer>> adjList, boolean[] visited) {
        visited[node] = true;
        if (waiting.contains(node)) return true;

        waiting.add(node);
        for(int neighbour: adjList.get(node)){
            if(!courseSchedule.contains(neighbour)){
                if(dfs(neighbour, adjList, visited))
                    return true;
            } 
        }

        waiting.remove(node);
        courseSchedule.add(node);
        return false;
    }

    private List<List<Integer>> createGraph(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) 
            adjList.add(new ArrayList<>());

        for (int[] edge : edges)
            adjList.get(edge[1]).add(edge[0]);

        return adjList;
    }
}
