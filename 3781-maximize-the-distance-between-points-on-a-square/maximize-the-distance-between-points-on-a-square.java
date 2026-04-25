import java.util.*;

class Solution {
    private long[] arr;
    private int n;
    private long side;

    public int maxDistance(int side, int[][] points, int k) {
        this.side = side;
        n = points.length;
        arr = new long[n];

        // Unfold: left(x=0), top(y=side), right(x=side), bottom(y=0)
        for (int i = 0; i < n; i++) {
            int x = points[i][0], y = points[i][1];
            if      (x == 0)    arr[i] = y;                    // left edge
            else if (y == side) arr[i] = side + x;             // top edge
            else if (x == side) arr[i] = 3L * side - y;        // right edge
            else                arr[i] = 4L * side - x;        // bottom edge
        }

        Arrays.sort(arr);

        // Binary search on minimum distance: [1, side]
        int lo = 1, hi = side;
        while (lo < hi) {
            int mid = (lo + hi + 1) / 2;
            if (canPlace(mid, k)) lo = mid;
            else                  hi = mid - 1;
        }
        return lo;
    }

    // Greedy check: try each point as the fixed first pick
    // Use binary search to jump to next valid point
    private boolean canPlace(long limit, int k) {
        for (int start = 0; start < n; start++) {
            int count = 1;
            long first = arr[start];
            long last  = first;

            for (int i = 1; i < k; i++) {
                // Binary search: smallest arr[idx] >= last + limit
                int idx = lowerBound(last + limit);
                if (idx >= n) break;

                // Circular constraint: gap between last picked and
                // wrapping back to `first` must still leave room
                // i.e., arr[idx] - first <= 4*side - limit
                if (arr[idx] - first > 4L * side - limit) break;

                last = arr[idx];
                count++;
            }

            if (count == k) return true;
        }
        return false;
    }

    // First index where arr[idx] >= target
    private int lowerBound(long target) {
        int lo = 0, hi = n;
        while (lo < hi) {
            int mid = (lo + hi) / 2;
            if (arr[mid] < target) lo = mid + 1;
            else                   hi = mid;
        }
        return lo;
    }
}