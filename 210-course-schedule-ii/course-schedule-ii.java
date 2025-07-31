class Solution {
    private Set<Integer> courseScheduled = new HashSet<>();
    private int[] courseSchedule;
    private int index = 0;
    private boolean[] waiting;
    private boolean[] visited;
    private List<List<Integer>> adjList;

    public int[] findOrder(int n, int[][] edges) {
        adjList = createGraph(edges, n);
        if(courseScheduled.size() == n) return new int[0];
        courseScheduled = new HashSet<>();
        visited = new boolean[n];
        waiting = new boolean[n];
        index = n -  1;
        courseSchedule = new int[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i] )
                if (dfs(i))
                    return new int[0];
        }

        return courseSchedule;
    }

    private boolean dfs(int node) {
        visited[node] = true;
        if (waiting[node]) return true;

        waiting[node] = true;
        for(int neighbour: adjList.get(node)){
            if(!courseScheduled.contains(neighbour)){
                if(dfs(neighbour))
                    return true;
            } 
        }

        waiting[node] = false;
        courseSchedule[index--] = node;
        courseScheduled.add(node);
        return false;
    }

    private List<List<Integer>> createGraph(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) 
            adjList.add(new ArrayList<>());

        for (int[] edge : edges){
            adjList.get(edge[1]).add(edge[0]);
            courseScheduled.add(edge[1]);
        }

        return adjList;
    }
}
