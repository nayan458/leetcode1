class Solution {

    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer,Deque<Integer>> hm = new HashMap<>();

        for(int i = 0; i < n; i++)
            hm.computeIfAbsent(arr[i],k -> new ArrayDeque<>()).offer(i);

        return bfs(arr,hm);
    }

    private int bfs(int[] arr, Map<Integer, Deque<Integer>> hm) {
        
        int n = arr.length;
        Deque<Integer> q = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        // Set<Integer> set = new HashSet<>();
        visited[0] = true;
        q.offer(0);
        int jump = -1;

        while(!q.isEmpty()) {
            
            jump++;
            int size = q.size();

            while(size-- > 0){
                int idx = q.poll();
                if(idx == n-1) return jump;

                // if(!set.contains(arr[idx])) {
                //     set.add(arr[idx]);
                    while(!hm.get(arr[idx]).isEmpty()) {
                        int neighbour = hm.get(arr[idx]).poll();
                        if(!visited[neighbour]){
                            if(neighbour == n-1) return jump+1;
                            visited[neighbour] = true;
                            q.offer(neighbour);
                        }
                    }
                // }
                
                if(idx > 0 && !visited[idx-1]){
                    q.offer(idx-1);
                    visited[idx-1] = true;
                }
                if(idx < n-1 && !visited[idx+1]){
                    q.offer(idx+1);
                    visited[idx+1] = true;
                }
            }
        }

        return -1;
    }   
}