class Solution {
    private static final int MOD = 1_000_000_007;
    public int specialTriplets(int[] nums) {
        Map<Integer, List<Integer>> hm = new HashMap<>();   // Map<Value, List<idx>>
        int count = 0;
        for(int i = 0; i < nums.length; i++)
            hm.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
        
        for(int j = 1; j < nums.length-1; j++) {
            int elem = nums[j] * 2;
            if(hm.containsKey(elem))
                count = ((count % MOD) + (countSpecialIdx(hm.get(elem), j) % MOD)) % MOD;
        }
        return count % MOD;
    }

    private int countSpecialIdx(List<Integer> arr, int idx) {
        if(arr.size() < 1 || (arr.get(0) > idx || arr.get(arr.size() - 1) < idx))
            return 0;
        int insertionIdx = searchInsertIdx(arr, idx);
        int left = insertionIdx;
        int right = arr.size() - insertionIdx;

        if(arr.get(insertionIdx) == idx)
            --right;

        return (int) (((left % MOD) * (1L % MOD) * (right % MOD)) % MOD);

    }

    private int searchInsertIdx(List<Integer> arr, int target) {
        int left = 0; 
        int right = arr.size() - 1;

        while(left <= right) {
        int mid = left + (right - left) / 2;
            if(arr.get(mid) == target)
                return mid;
            if(arr.get(mid) < target)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return left;
    }
}