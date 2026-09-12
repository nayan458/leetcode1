// class Solution {
//     private List<List<Integer>> inter;
//     public int[] maximumWeight(List<List<Integer>> intervals) {

//         Collections.sort(intervals,(a,b) -> {
//             if(a.get(0) == b.get(0))
//                 return a.get(1) - b.get(1);
//             return a.get(0) - b.get(0);
//         });

//         this.inter = new ArrayList<>(intervals);

//         // return new int[1];
//         List<Integer> dp(intervals.size(), new ArrayList<>());
//     }

//     private List<Integer> dp(int idx, List<Integer> x){
//         if(idx == 0 || c = 0)
//             new ArrayList<>(x);
//         if(x.size() != 0 && inter.get(idx-1).get(1) <= inter.get(x.getLast()).get(2))
//             return dp(idx - 1, new ArrayList<>(x));
//         List<Integer> take = dp(idx-1, new ArrayList<>(x).add(idx-1));
//         List<Integer> skip = dp(idx-1, new ArrayList<>(x));
//         return new ArrayList<>(Max(take,skip));
//     }   

//     private List<Integer> Max(List<Integer> take, List<Integer> skip) {
//         int takeWeight = 0, skipWeight = 0;
//         for(Integer idx: take)
//             takeWeight += inter.get(idx).get(2);
//         for(Integer idx: skip)
//             skipWeight += inter.get(idx).get(2);
//         return takeWeight > skipWeight ? take : skip;
//     }
// }

class Solution {
    public int[] maximumWeight(List<List<Integer>> intervals) {
        int n = intervals.size();
        int[][] iv = new int[n][3];
        for (int i = 0; i < n; i++)
            for (int c = 0; c < 3; c++) iv[i][c] = intervals.get(i).get(c);

        Integer[] order = new Integer[n];
        for (int i = 0; i < n; i++) order[i] = i;
        Arrays.sort(order, (a, b) -> iv[a][1] - iv[b][1]);
        int[] rights = new int[n];
        for (int p = 0; p < n; p++) rights[p] = iv[order[p]][1];

        long[] prevScore = new long[n + 1];
        int[][] prevIds = new int[n + 1][0];
        for (int k = 0; k < 4; k++) {
            long[] curScore = new long[n + 1];
            int[][] curIds = new int[n + 1][0];
            for (int p = 1; p <= n; p++) {
                int i = order[p - 1];  // take next interval
                int l = iv[i][0], w = iv[i][2];
                int lo = 0, hi = n;  // lower_bound: intervals ending before l
                while (lo < hi) { 
                    int mid = (lo + hi) >>> 1; 
                    if (rights[mid] < l) lo = mid + 1; 
                    else hi = mid; 
                }

                long takeScore = prevScore[lo] + w;
                int[] takeIds = insertSorted(prevIds[lo], i);
                if (better(takeScore, takeIds, curScore[p - 1], curIds[p - 1])) {
                    curScore[p] = takeScore; 
                    curIds[p] = takeIds;
                } else {
                    curScore[p] = curScore[p - 1]; 
                    curIds[p] = curIds[p - 1];
                }
            }
            prevScore = curScore; prevIds = curIds;
        }
        return prevIds[n];
    }

    private static boolean better(long s1, int[] a, long s2, int[] b) {
        if (s1 != s2) return s1 > s2;  // higher score wins
        int m = Math.min(a.length, b.length);
        for (int i = 0; i < m; i++)
            if (a[i] != b[i]) return a[i] < b[i];  // then lexicographically smaller
        return a.length < b.length;
    }

    private static int[] insertSorted(int[] ids, int x) {
        int[] out = new int[ids.length + 1];
        int i = 0;
        while (i < ids.length && ids[i] < x) { 
            out[i] = ids[i]; 
            i++; 
        }
        out[i] = x;
        for (; i < ids.length; i++) 
            out[i + 1] = ids[i];
        return out;
    }
}