class Solution {
    private static int MOD = 1_000_000_007;
    public int maximumProduct(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        long product = 1;
        int count_Zero = 0;
        for(int i = 0; i < nums.length; i++){
            if(count_Zero > k)
                return 0;
            heap.add(nums[i]);
            if(nums[i] == 0)
                count_Zero++;
        }

        for(int i = 0; i < k; i++)
            heap.add(heap.poll() + 1);
        
        while(!heap.isEmpty())
            product = (product * heap.poll()) % MOD;

        return (int) product;
    }
}