class Solution {
    private final Map<Integer,Integer> hm = new HashMap<>(); // index, frequency of zero

    public int countValidSelections(int[] nums) {
        List<Integer> mergeSum = merge(nums);
        int[] prefixSum = prefixSumCalc(mergeSum);
        return Count(prefixSum, hm);
        
    }

    private int Count(int[] prefixSum, Map<Integer,Integer> hm) {
        int n = prefixSum.length;
        if(n == 0)
            return (hm.get(0) * 2);
        if(n == 1 && prefixSum[0] == 1)
            return hm.getOrDefault(0,0) + hm.getOrDefault(1,0);

        int count = 0;

        count += (
            (2 * hm.getOrDefault(binarySearch(prefixSum, 0), 0)) + 
            hm.getOrDefault(binarySearch(prefixSum, 1), 0) +
            hm.getOrDefault(binarySearch(prefixSum, -1), 0)
            );

        return count;
    }

    private int binarySearch(int[] arr, int target) {
        int l = 0; 
        int r = arr.length - 2;
        int total = arr[arr.length - 1];
        int mid = 0;
        while(l <= r) {
            mid = l + ((r - l) / 2);
            int x = total - (2 * arr[mid]);
            if(x == target)
                return mid + 1;
            if(x > target)
                l = mid + 1;
            else
                r = mid - 1;
        }
        return -1;
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