class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {

        // sort the array
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        
        int i = 1, j = 0, breakPoint = intervals[0][1];
        int start = intervals[0][0];
        
        while(i<intervals.length){
            if(intervals[i][0] < breakPoint)
                j++;
            else
                breakPoint = intervals[i][1];
            ++i;
        }

        return j;
    }
}
// class Solution {
//     public int eraseOverlapIntervals(int[][] intervals) {

//         // sort the array
//         Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        
//         int i = 0, j = 0, breakPoint = intervals[0][1];
//         while(i<intervals.length){
//             int start = intervals[i][0];
//             breakPoint = intervals[i][1];

//             while(i + 1 < intervals.length && (intervals[i + 1][0] < breakPoint || intervals[i+1][0] == start)){
//                 ++i;
//                 ++j;
//                 breakPoint = Math.min(breakPoint,intervals[i][1]);
//             }
//             ++i;
//         }

//         return j;
//     }
// }