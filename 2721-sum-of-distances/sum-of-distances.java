class Solution {
    public long[] distance(int[] nums) {
        Map<Integer,List<Integer>> hm = new HashMap<>();
        long[] distances = new long[nums.length];

        for(int i = 0; i < nums.length; i++)
            hm.computeIfAbsent(nums[i],k -> new ArrayList<>()).add(i);
        
        for(List<Integer> idxs: hm.values()) 
            compute(distances,idxs);

        return distances;
    }

    private void compute(long[] distance, List<Integer> idxs) {
        
        int n = idxs.size();
        long[] prefixSum = new long[n];

        if(n == 1) return;
        
        prefixSum[0] = idxs.get(0);

        for(int i = 1; i < n; i++)
            prefixSum[i] = prefixSum[i-1] + idxs.get(i);

        for(int i = 0; i < n; i++) {
    
            long prefixCurr = i * 1l * idxs.get(i);
            long suffixCurr = (n-i-1) * 1l * idxs.get(i);

            long prefixSumOfElem = i == 0 ? 0 : prefixSum[i-1];
            long suffixSumOfElem = i == n-1 ? 0 : prefixSum[n-1] - prefixSum[i];

            long prefixDistance = prefixCurr - prefixSumOfElem;
            long suffixDistance = suffixSumOfElem - suffixCurr;

            distance[idxs.get(i)] = prefixDistance + suffixDistance;
        }
    }
}