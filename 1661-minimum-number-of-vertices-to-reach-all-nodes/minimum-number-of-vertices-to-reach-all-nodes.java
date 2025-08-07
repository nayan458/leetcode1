class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        Set<Integer> set = new HashSet<>();
        int[] indegree = new int[n];

        for(List<Integer> edge: edges)
            indegree[edge.get(1)] += 1;
        
        for(int i = 0; i < n; i++)
            if(indegree[i] == 0)
                set.add(i);
        
        return new ArrayList<>(set);
    }
}