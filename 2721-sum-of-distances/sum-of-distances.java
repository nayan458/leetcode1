class Solution {

    static class BIT {
        private long[] countTree, sumTree;
        private int n;

        BIT(int n) {
            this.n = n;
            this.countTree = new long[n + 1];
            this.sumTree   = new long[n + 1];
        }

        void update(int i, long actualIdx) {
            for (int j = i + 1; j <= n; j += j & -j) {
                countTree[j] += 1;
                sumTree[j]   += actualIdx;
            }
        }

        // count and sum of [0..i]
        long[] query(int i) {
            long count = 0, sum = 0;
            for (int j = i + 1; j > 0; j -= j & -j) {
                count += countTree[j];
                sum   += sumTree[j];
            }
            return new long[]{count, sum};
        }
    }

    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] distances = new long[n];

        // Group indices by value
        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++)
            groups.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);

        for (List<Integer> idxs : groups.values()) {
            int m = idxs.size();
            if (m == 1) continue;

            // BIT sized to the group, not to n
            BIT bit = new BIT(m);

            for (int rank = 0; rank < m; rank++) {
                int idx = idxs.get(rank);         // actual array index
                
                // prefix: all ranks before current
                long[] pre     = rank > 0 ? bit.query(rank - 1) : new long[]{0, 0};
                long prefixDist = pre[0] * idx - pre[1];

                // suffix: derive from totals - prefix - self (not yet inserted)
                // totals computed lazily after full build — handled below
                // Insert current element at its rank
                bit.update(rank, idx);

                distances[idx] = prefixDist; // suffix added in second pass
            }

            // Second pass: suffix distances using total prefix - prefix up to rank
            long[] total = bit.query(m - 1);   // full group count and sum

            for (int rank = 0; rank < m; rank++) {
                int idx = idxs.get(rank);

                long[] pre      = rank > 0 ? bit.query(rank - 1) : new long[]{0, 0};
                long suffixCount = total[0] - pre[0] - 1;          // exclude self
                long suffixSum   = total[1] - pre[1] - idx;
                long suffixDist  = suffixSum - suffixCount * idx;

                distances[idx] += suffixDist;
            }
        }

        return distances;
    }
}