class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1) return 0;

        // Group indices by value
        Map<Integer, List<Integer>> valueToIndices = new HashMap<>();
        for (int i = 0; i < n; i++)
            valueToIndices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        // BFS - level by level (each level = 1 jump)
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n];
        Set<Integer> expandedValues = new HashSet<>();

        queue.offer(0);
        visited[0] = true;
        int jumps = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            jumps++;

            while (size-- > 0) {
                int idx = queue.poll();

                // Check left, right neighbors
                int[] neighbors = {idx - 1, idx + 1};
                for (int neighbor : neighbors) {
                    if (neighbor == n - 1) return jumps;
                    if (neighbor >= 0 && neighbor < n && !visited[neighbor]) {
                        visited[neighbor] = true;
                        queue.offer(neighbor);
                    }
                }

                // Check same-value neighbors
                if (!expandedValues.contains(arr[idx])) {
                    expandedValues.add(arr[idx]);
                    for (int neighbor : valueToIndices.get(arr[idx])) {
                        if (neighbor == n - 1) return jumps;
                        if (!visited[neighbor]) {
                            visited[neighbor] = true;
                            queue.offer(neighbor);
                        }
                    }
                }
            }
        }

        return -1; // unreachable given problem constraints
    }
}