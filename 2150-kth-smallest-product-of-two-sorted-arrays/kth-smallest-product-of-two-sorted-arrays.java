class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long left = -10000000000L, right = 10000000000L;
        long ans = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;
            long count = countLessEqual(mid, nums1, nums2);

            if (count >= k) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }

    private long countLessEqual(long mid, int[] nums1, int[] nums2) {
        long count = 0;
        for (int a : nums1) {
            if (a == 0) {
                if (mid >= 0) {
                    count += nums2.length;
                }
            } else if (a > 0) {
                // count how many b in nums2 such that a * b <= mid
                int l = 0, r = nums2.length - 1, res = -1;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= mid) {
                        res = m;
                        l = m + 1;
                    } else {
                        r = m - 1;
                    }
                }
                count += res + 1;
            } else {
                // a < 0
                int l = 0, r = nums2.length - 1, res = nums2.length;
                while (l <= r) {
                    int m = (l + r) / 2;
                    if ((long)a * nums2[m] <= mid) {
                        res = m;
                        r = m - 1;
                    } else {
                        l = m + 1;
                    }
                }
                count += nums2.length - res;
            }
        }
        return count;
    }
}

// // Binary Search on Answer
// class Solution {
//     public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
//         long beg = (long) Integer.MIN_VALUE * Integer.MIN_VALUE;
//         long end = (long) Integer.MAX_VALUE * Integer.MAX_VALUE;
//         long mid = beg + ((end - beg) / 2);
//         return mid;
//     }
// }
// Brute force solution with Error: TLE
// class Solution {
//     public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
//         List<Long> prod = new ArrayList<>();

//         for(int i = 0; i < nums1.length; i++)
//             for(int j = 0; j < nums2.length; j++)
//                 prod.add( 1L * nums1[i]*nums2[j]);
//         Collections.sort(prod);

//         return prod.get((int)k - 1);
//     }
// }