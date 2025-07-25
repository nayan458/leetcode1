
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if(source == destination)   return true;

        List<List<Integer>> adjList = new ArrayList<>();
        boolean[] visited = new boolean[n];
        Stack<Integer> st = new Stack<>();

        for(int i = 0; i < n; i++)
            adjList.add(new ArrayList<>());
        
        for(int[] edge: edges){
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
        }

        st.push(source);
        visited[source] = true;

        while(!st.isEmpty()){
            int elem = st.pop();
            for(Integer el: adjList.get(elem)){
                if(visited[el]) continue;
                if(el == destination) return true;
                st.push(el);
                visited[el] = true;
            }
        }
        return false;
    }
}
// class Solution {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         if (source == destination) {
//             return true;
//         }
        
//         // Use adjacency list instead of matrix - much more memory efficient
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }
        
//         // Build adjacency list
//         for (int[] edge : edges) {
//             adj.get(edge[0]).add(edge[1]);
//             adj.get(edge[1]).add(edge[0]); // undirected graph
//         }
        
//         // BFS traversal
//         Queue<Integer> queue = new LinkedList<>();
//         boolean[] visited = new boolean[n]; // Use boolean array instead of HashSet
        
//         queue.offer(source);
//         visited[source] = true;
        
//         while (!queue.isEmpty()) {
//             int current = queue.poll();
            
//             // Check all neighbors
//             for (int neighbor : adj.get(current)) {
//                 if (neighbor == destination) {
//                     return true;
//                 }
                
//                 if (!visited[neighbor]) {
//                     visited[neighbor] = true;
//                     queue.offer(neighbor);
//                 }
//             }
//         }
        
//         return false;
//     }
// }

// // Alternative: Even more memory efficient DFS solution
// class SolutionDFS {
//     public boolean validPath(int n, int[][] edges, int source, int destination) {
//         if (source == destination) {
//             return true;
//         }
        
//         // Build adjacency list
//         List<List<Integer>> adj = new ArrayList<>();
//         for (int i = 0; i < n; i++) {
//             adj.add(new ArrayList<>());
//         }
        
//         for (int[] edge : edges) {
//             adj.get(edge[0]).add(edge[1]);
//             adj.get(edge[1]).add(edge[0]);
//         }
        
//         boolean[] visited = new boolean[n];
//         return dfs(adj, source, destination, visited);
//     }
    
//     private boolean dfs(List<List<Integer>> adj, int current, int destination, boolean[] visited) {
//         if (current == destination) {
//             return true;
//         }
        
//         visited[current] = true;
        
//         for (int neighbor : adj.get(current)) {
//             if (!visited[neighbor] && dfs(adj, neighbor, destination, visited)) {
//                 return true;
//             }
//         }
        
//         return false;
//     }
// }
// // class Solution {
// //     public boolean validPath(int n, int[][] edges, int source, int destination) {
// //         if(source == destination)
// //             return true;
        
// //         // create adjacency Matrix
// //         int[][] adj = new int[n][n];
        
// //         for(int i = 0; i < edges.length; i++){
// //             adj[edges[i][0]][edges[i][1]] = 1;
// //             adj[edges[i][0]][edges[i][0]] = 1;
// //             adj[edges[i][1]][edges[i][0]] = 1;
// //             adj[edges[i][1]][edges[i][1]] = 1;
// //         }

// //         // bfs traversal

// //         Queue<Integer> q = new LinkedList<>();
// //         Set<Integer> visited = new HashSet<>();

// //         q.add(source);
// //         visited.add(source);

// //         while(!q.isEmpty()){
// //             int elem = q.poll();
// //             System.out.print(elem + ", ");
// //             for(int i = 0; i < n; i++){
// //                 if(adj[elem][i] == 0 || visited.contains(i))
// //                     continue;

// //                 if(i == destination)
// //                     return true;
                    
// //                 visited.add(i);
// //                 q.add(i);
// //             }
// //         }

// //         return false;
// //     }
// // }