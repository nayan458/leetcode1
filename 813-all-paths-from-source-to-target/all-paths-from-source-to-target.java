class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        path(0, graph, new ArrayList<>());
        return ans;
    }

    private void path(int node, int[][] graph,List<Integer> arr){
        arr.add(node);

        if(node == n - 1)
            ans.add(new ArrayList<>(arr));

        for(int elem: graph[node])
            path(elem, graph, arr);
            
        arr.remove(arr.size() - 1);
        return;
    }
}