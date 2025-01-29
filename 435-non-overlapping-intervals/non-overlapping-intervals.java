class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        List<int[]> result = new ArrayList<>();

        // sort the array
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
        for (int[] row : intervals) {
            System.out.println(Arrays.toString(row));
        }

        int i = 0, j = 0, breakPoint = intervals[0][1];
        while(i<intervals.length){
            int start = intervals[i][0];
            breakPoint = intervals[i][1];

            while(i + 1 < intervals.length && (intervals[i + 1][0] < breakPoint || intervals[i+1][0] == start)){
                ++i;
                ++j;
                breakPoint = Math.min(breakPoint,intervals[i][1]);
            }

            ++i;

        }

        return j;
    }
}