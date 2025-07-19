class Solution {
    private static int MOD = 1_000_000_007;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        long product = 1;

        for(int num : nums) heap.add(num);

        for(int i = 0; i < k; i++)
            heap.add(heap.poll() + 1);
        
        while(!heap.isEmpty())
            product = (product * heap.poll()) % MOD;

        return (int) product;
    }
}