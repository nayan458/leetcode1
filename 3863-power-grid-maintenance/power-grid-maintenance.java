class Solution {
    int[] parent, size;
    Map<Integer, PriorityQueue<Integer>> mp = new HashMap<>();

    int findParent(int node) {
        if (parent[node] == node) return node;
        return parent[node] = findParent(parent[node]);
    }

    void Union(int u, int v) {
        int up = findParent(u);
        int vp = findParent(v);

        if (up == vp) return;

        if (size[up] > size[vp]) {
            size[up] += size[vp];
            parent[vp] = up;
            PriorityQueue<Integer> pqV = mp.get(vp);
            PriorityQueue<Integer> pqU = mp.get(up);
            while (!pqV.isEmpty()) pqU.offer(pqV.poll());
        } else {
            size[vp] += size[up];
            parent[up] = vp;
            PriorityQueue<Integer> pqU = mp.get(up);
            PriorityQueue<Integer> pqV = mp.get(vp);
            while (!pqU.isEmpty()) pqV.offer(pqU.poll());
        }
    }

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        parent = new int[c];
        size = new int[c];
        boolean[] offline = new boolean[c];

        for (int i = 0; i < c; i++) {
            parent[i] = i;
            size[i] = 1;
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            pq.offer(i);
            mp.put(i, pq);
        }

        for (int[] conn : connections) {
            int u = conn[0] - 1, v = conn[1] - 1;
            Union(u, v);
        }

        List<Integer> ans = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int node = q[1] - 1;

            if (type == 1) {
                if (!offline[node]) {
                    ans.add(node + 1);
                    continue;
                }
                int par = findParent(node);
                PriorityQueue<Integer> pq = mp.get(par);
                while (!pq.isEmpty() && offline[pq.peek()]) pq.poll();
                ans.add(pq.isEmpty() ? -1 : pq.peek() + 1);
            } else {
                offline[node] = true;
            }
        }

        return ans.stream().mapToInt(i -> i).toArray();
    }
}
// class Solution {
//     public int[] processQueries(int c, int[][] connections, int[][] queries) {
//         boolean[] offline = new boolean[c];
//         List<List<Integer>> adjList = CreateAdjList(connections, c);
//         List<Integer> ans = new ArrayList<>();

//         for(int[] query: queries) {
//             if(query[0] == 2)
//                 offline[query[1] - 1] = !offline[query[1] - 1];
//             else {
//                 ans.add(ping(query[1]-1, adjList, offline, new boolean[c]));
//             }
//         }

//         int[] answ = new int[ans.size()]; 
//         for(int i = 0; i < ans.size(); i++) {
//             answ[i] = ans.get(i);
//         }
//         return answ;
//     }

//     private Integer ping(int station, List<List<Integer>> adjList, boolean[] offline, boolean[] visited) {
//         int x = Integer.MAX_VALUE;
//         visited[station] = true;

//         if(!offline[station])
//             return station + 1;

//         for(Integer operational_station : adjList.get(station)) {
//             if(visited[operational_station])
//                 continue;
//             x = Math.min(ping(operational_station, adjList, offline, visited),x);
//         }

//         return x == Integer.MAX_VALUE ? -1 : x;
//     }

//     private List<List<Integer>> CreateAdjList (int[][] connections,int c) {
//         List<List<Integer>> adjList = new ArrayList<>();

//         for(int i = 0; i < c; i++)
//             adjList.add(new ArrayList<>());

//         for(int[] conn: connections) {
//             int u = conn[0] - 1;
//             int v = conn[1] - 1;

//             adjList.get(u).add(v);
//             adjList.get(v).add(u);
//         }

//         return adjList;
//     }

// }