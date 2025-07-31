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
        Iterator<Integer> iterator = hm.get(node).iterator();
        while (iterator.hasNext()) {
            int elem = iterator.next();
            if (!courseSchedule.contains(elem)) {
                if (dfs(elem, adjList, visited))
                    return true;
                iterator.remove(); // safely remove from set
            } else {
                iterator.remove(); // safely remove if already in courseSchedule
            }
        }

        waiting.remove(node);
        courseSchedule.add(node);
        return false;
    }

    private List<List<Integer>> createGraph(int[][] edges, int n) {
        List<List<Integer>> adjList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
            hm.put(i, new HashSet<>());
        }

        for (int[] edge : edges) {
            adjList.get(edge[0]).add(edge[1]);
            hm.get(edge[1]).add(edge[0]);
        }

        return adjList;
    }
}
