class Solution {
    private final Map<Integer,Integer> hm = new HashMap<>(); // index, frequency of zero

    public int countValidSelections(int[] nums) {
        List<Integer> mergeSum = merge(nums);
        int[] prefixSum = prefixSumCalc(mergeSum);

        return Count(prefixSum, hm);
        
    }

    private int Count(int[] prefixSum, Map<Integer,Integer> hm) {
        int count = 0;
        int n = prefixSum.length;
        if(n == 0)
            return (hm.get(0) * 2);
        if(n == 1 && prefixSum[0] == 1)
            return hm.getOrDefault(0,0) + hm.getOrDefault(1,0);
            
        for(int i = 0; i < n - 1; i++) {
            int target = Math.abs(prefixSum[n-1] - (2 * prefixSum[i]));
            System.out.println(target);
            if( target == 0){
                System.out.println(i);
                count += (2 * hm.getOrDefault(i+1,1));
            }
            if( target == 1)
                count += hm.getOrDefault(i+1,1);
        }

        return count;
    }

    private List<Integer> merge(int[] nums) {
        List<Integer> mergeSum = new ArrayList<>();
        int i = 0;
        while(i < nums.length) {
            int sum = 0;
            while(i < nums.length && nums[i] == 0) {
                hm.put(mergeSum.size(), hm.getOrDefault(mergeSum.size(),0)+1);
                i++;
            }
            while(i < nums.length && nums[i] != 0){
                sum += nums[i++];
            }
            if(sum != 0)
                mergeSum.add(sum);
        }

        return mergeSum;
    }

    private int[] prefixSumCalc(List<Integer> mergeSum) {
        int[] prefixSum = new int[mergeSum.size()];
        int pSum = 0;
        int i = 0;

        for(Integer elem: mergeSum){
            pSum += elem;
            prefixSum[i++] = pSum;
        }

        return prefixSum;
    }
}