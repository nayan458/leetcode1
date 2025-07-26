class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = createGraph(prerequisites, numCourses);
        boolean[] visited = new boolean[numCourses];
        boolean[] onPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adj, visited, onPath)) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean hasCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] onPath) {
        visited[node] = true;
        onPath[node] = true;

        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                if (hasCycle(neighbor, adj, visited, onPath)) {
                    return true; // cycle found in deeper call
                }
            } else if (onPath[neighbor]) {
                return true; // cycle found: back edge to ancestor
            }
        }

        onPath[node] = false; // backtrack: remove from current path
        return false;
    }


    public List<List<Integer>> createGraph(int[][] edges, int n){
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        
        for(int[] edge: edges)
            adj.get(edge[0]).add(edge[1]);
        
        return adj;
    }
}
// class Solution {
//     public boolean canFinish(int numCourses, int[][] prerequisites) {
//         List<Set<Integer>> adj = new ArrayList<>();
//         boolean[] visited = new boolean[numCourses];
//         Set<Integer> presentPath = new HashSet<>();
//         Stack<Integer> st = new Stack<>();

//         for(int i = 0; i < numCourses; i++)
//             adj.add(new LinkedHashSet<>());
        
//         for(int[] edge: prerequisites){
//             if(adj.get(edge[1]).contains(edge[0])) return false;
//             adj.get(edge[0]).add(edge[1]);
//         }

//         for(int i = 0; i < numCourses; i++){
//             if(visited[i]) continue;
//             presentPath = new HashSet<>();
//             visited[i] = true;
//             st.push(i);
//             presentPath.add(i);
            
//             while(!st.isEmpty()){
//                 int elem = st.pop();
//                 for(int node: adj.get(elem)){
//                     if(presentPath.contains(node))     return false;

//                     if(!visited[node]) visited[node] = true;
                    
//                     presentPath.add(node);
//                 }
//             }
//         }

//         return true;
//     }
// }