class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] hasIncomming = new boolean[n];

        for(List<Integer> edge: edges)
            hasIncomming[edge.get(1)] = true;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0; i < n; i++)
            if(!hasIncomming[i])
                ans.add(i);

        return ans;
    }
}
// class Solution {
//     public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
//         int[] indegree = new int[n];

//         for(List<Integer> edge: edges)
//             indegree[edge.get(1)] += 1;
        
//         List<Integer> ans = new ArrayList<>();
//         for(int i = 0; i < n; i++)
//             if(indegree[i] == 0)
//                 ans.add(i);
        
//         return ans;
//     }
// }