class Solution {
    private List<List<Integer>> ans = new ArrayList<>();
    private int n;
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        n = graph.length;
        path(0, graph, new ArrayList<>());
        return ans;
    }

    private void path(int node, int[][] graph,List<Integer> arr){
        if(node == n - 1){
            arr.add(node);
            ans.add(new ArrayList<>(arr));
            arr.remove(arr.size() - 1);
            return;
        }

        arr.add(node);

        for(int elem: graph[node])
            path(elem, graph, arr);
        System.out.println(node + ": " + arr);
        arr.remove(arr.size() - 1);
        return;
    }
}