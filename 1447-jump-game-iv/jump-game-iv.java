class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer,Set<Integer>> hm = new HashMap<>();

        for(int i = 0; i < n; i++)
            hm.computeIfAbsent(arr[i],k -> new HashSet<>()).add(i);

        // create graph
        // List<Set<Integer>> adjList = createGraph(hm, arr);

        return bfs(arr,hm);
    }

    private int bfs(int[] arr, Map<Integer,Set<Integer>> hm) {
        
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        Set<Integer> set = new HashSet<>();
        visited[0] = true;
        q.addLast(0);
        int jump = -1;

        while(!q.isEmpty()) {
            
            jump++;
            int size = q.size();

            while(size-- > 0){
                int idx = q.removeFirst();
                if(idx == n-1) return jump;

                if(!set.contains(arr[idx])) 
                    for(int neighbour: hm.get(arr[idx])) {
                        if(!visited[neighbour]){
                            visited[neighbour] = true;
                            q.addLast(neighbour);
                        }
                    }
                set.add(arr[idx]);
                
                if(idx > 0 && !visited[idx-1]){
                    q.addLast(idx-1);
                    visited[idx-1] = true;
                }
                if(idx < n-1 && !visited[idx+1]){
                    q.addLast(idx+1);
                    visited[idx+1] = true;
                }
            }
        }

        return n-1;
    }   

    // private List<Set<Integer>> createGraph(HashMap<Integer,Set<Integer>> hm, int[] arr) {
    //     List<Set<Integer>> adjList = new ArrayList<>();
        
    //     for(int i = 0; i < n; i++) {
    //         adjList.add(new HashSet<>());
    //         if(i > 0)
    //             adjList.get(i).add(i-1);
    //         if(i < n-1)
    //             adjList.get(i).add(i+1);
    //     }

    //     for(int u = 0; u < n; u++) {
    //         for(int v: hm.get(arr[u])) {
    //             adjList.get(u).add(v);
    //             adjList.get(v).add(u);
    //         }
    //         set.add(arr[u]);
    //     }
    //     return adjList;
    // }

    // private int bfs(int[] arr,List<Set<Integer>> adjList) {
        
    //     int n = arr.length;
    //     Deque<int[]> q = new ArrayDeque<>();
    //     boolean[] visited = new boolean[n];

    //     visited[0] = true;
    //     q.addLast(new int[]{0,0});

    //     while(!q.isEmpty()) {
    //         int[] node = q.removeFirst();
    //         int idx = node[0];
    //         int jump = node[1];

    //         if(idx == n-1) return jump;

    //         for(int neighbour: adjList.get(idx)) {
    //             if(!visited[neighbour]){
    //                 visited[neighbour] = true;
    //                 q.addLast(new int[]{neighbour,jump+1});
    //             }
    //         }
    //     }

    //     return n-1;
    // }   
}