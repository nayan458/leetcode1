class Solution {
    public int minMirrorPairDistance(int[] nums) {
        int n =  nums.length;
        int min = Integer.MAX_VALUE;
        Map<Long,List<Integer>> hm = new HashMap<>();

        for(int i = 0; i < n; i++)
            hm.computeIfAbsent((long)(nums[i] * 1l), k -> new ArrayList<>()).add(i);
        for(int i = 0; i < n-1;i++){
            if(min == 1) return 1;
            long rev = reverse(nums[i]);
            if(!hm.containsKey(rev)) continue;
            min = Math.min(min,minDiff(rev,hm.get(rev),i));
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private int minDiff(long x, List<Integer> list, int idx){
        int pos = upperBound(list, idx);
        if(pos < list.size())
            return list.get(pos) - idx;
        return Integer.MAX_VALUE;
    }

    private long reverse(int x) {
        long rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }

    private int upperBound(List<Integer> list, int target){
        int l = 0, r = list.size();
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (list.get(mid) > target) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }
}
