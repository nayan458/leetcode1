class Solution {
    public int kthFactor(int n, int k) {
        boolean[] visited = new boolean[n+1];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Comparator.reverseOrder());

        for(int i = 1; i*i <= n; i++) {
            if(n % i == 0) {
                if(visited[i])
                    continue;
                heap.add(i);
                visited[i] = true;
                if(visited[n/i])
                    continue;
                heap.add(n/i);
                visited[n/i] = true;
            }
            while(heap.size() > k)
                heap.poll();
        }
        while(heap.size() > k)
            heap.poll();
        System.out.println(heap);
        if(heap.size() < k)
            return -1;
        return heap.poll();
    }
}