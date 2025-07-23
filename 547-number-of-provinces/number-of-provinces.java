class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length, count = 0;
        boolean[] vis = new boolean[isConnected.length];
        
        for(int i = 0; i < n; i++){
            if(vis[i] == true)
                continue;
            vis[i] = true;
            Queue<Integer> q = new LinkedList<>();
            q.add(i);
            while(!q.isEmpty()){
                int k = q.poll();
                vis[k] = true;
                for(int j = 0; j < n; j++){
                    if(isConnected[k][j] == 1 && vis[j] != true){
                        vis[j] = true;
                        q.add(j);
                    }
                }
            }
            count++;
        }

        return count;
    }
}

// 1 1 0
// 1 1 0
// 0 0 1