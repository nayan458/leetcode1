class Solution {
    private static int MOD = 1_000_000_007;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long product = 1;

        for(int num : nums) heap.add(num);

        // for(int i = 0; i < k; i++)
        //     heap.add(heap.poll() + 1);

        while(k > 0){
            int current = heap.poll();
            int next = heap.isEmpty() ? Integer.MAX_VALUE : heap.peek();

            int gap = Math.min(k, next - current);

            if(gap == 0)  gap = 1;
            
            heap.add(current + gap);
            k -= gap;
        }
        
        while(!heap.isEmpty())
            product = (product * heap.poll()) % MOD;

        return (int) product;
    }
}