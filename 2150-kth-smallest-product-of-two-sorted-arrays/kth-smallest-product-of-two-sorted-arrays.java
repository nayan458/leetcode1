import java.util.Arrays;

class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        int n1 = nums1.length, n2 = nums2.length;

        // Split nums1 and nums2 into positive and negative parts
        int pivot1 = findFirstZero(nums1); // index of first non-negative in nums1
        int pivot2 = findFirstZero(nums2); // index of first non-negative in nums2

        int[] pos1 = Arrays.copyOfRange(nums1, pivot1, n1); // non-negatives from nums1
        int[] pos2 = Arrays.copyOfRange(nums2, pivot2, n2); // non-negatives from nums2

        int[] neg1 = reverseAndNegate(Arrays.copyOfRange(nums1, 0, pivot1)); // negatives as positive
        int[] neg2 = reverseAndNegate(Arrays.copyOfRange(nums2, 0, pivot2)); // negatives as positive

        // Total negative products = (neg1 × pos2) + (pos1 × neg2)
        long negCount = (long) neg1.length * pos2.length + (long) pos1.length * neg2.length;

        long sign = 1;
        if (k > negCount) {
            // We're looking for non-negative products
            k -= negCount;
        } else {
            // Flip search to negative products using neg1 × neg2 and pos1 × pos2
            int[] tmp = neg2;
            neg2 = pos2;
            pos2 = tmp;
            sign = -1;
            k = negCount - k + 1; // convert to kth largest negative
        }

        // Binary search to find the smallest product for given k
        long left = 0, right = (long) 1e10;
        while (left < right) {
            long mid = left + (right - left) / 2;
            long total = countLessEqual(mid, neg1, neg2) + countLessEqual(mid, pos1, pos2);

            if (total >= k) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left * sign;
    }

    // Counts number of pairs (a,b) such that a in n1, b in n2 and a*b <= max
    private long countLessEqual(long max, int[] n1, int[] n2) {
        long count = 0;
        int j = n2.length - 1;

        for (int i = 0; i < n1.length; i++) {
            while (j >= 0 && (long) n1[i] * n2[j] > max) {
                j--;
            }
            count += j + 1;
        }
        return count;
    }

    // Finds the index of the first non-negative number
    private int findFirstZero(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // Reverse and negate the array to make it increasing positive
    private int[] reverseAndNegate(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = -arr[arr.length - 1 - i];
        }
        return result;
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