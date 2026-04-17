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
        for(int elem: list)
            if(elem > idx) return elem-idx;
        return Integer.MAX_VALUE;
    }

    long reverse(int x) {
        long rev = 0;
        while (x > 0) {
            rev = rev * 10 + (x % 10);
            x /= 10;
        }
        return rev;
    }

    // private int binarySearch(){
    //     int l = 0, r = n-1;
    //     while(l <= r) {
    //         int mid = l + (r-l)/2;
    //         boolean possible = isPossible(nums, reverseNum, mid);
    //         if(possible && min == mid) break;
    //         if(possible) {
    //             min = Math.min(min,mid);
    //             r = mid-1;
    //         } else {
    //             l = mid+1;
    //         }
    //     }
    // }
    // boolean isPossible(int[] nums, long[] reverseNum, int mid) {
    //     if(mid == 0) return false;
    //     System.out.println(mid);

    //     for(int i = 0; i < nums.length - mid; i++){
    //         if(reverseNum[i] == nums[i+mid])
    //             return true;
    //     }

    //     return false;
    // }
}
