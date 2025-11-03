class Solution {
    public int minCost(String colors, int[] neededTime) {
        PriorityQueue<Integer> heap;
        int count = 0;
        int n = neededTime.length;

        for(int i = 0; i < n; i++) {
            heap = new PriorityQueue<>();
            char ch = colors.charAt(i);

            // System.out.println("\n" + ch);
            // System.out.println("Add elements to the heap: ");
            while(i < n && colors.charAt(i) == ch ) {
                heap.add(neededTime[i]);
                i++;
            }

            while(heap.size() > 1) {
                count += heap.poll();
            }
            --i;
        }

        return count;
    }
}