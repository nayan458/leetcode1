class Solution {
    public int[][] merge(int[][] intervals) {

        // initialize array to store the result
        ArrayList<List<Integer>> result = new ArrayList<>();

        // sort the array
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        

        int i = 0, j = 0, breakPoint = intervals[0][1];
        while(i<intervals.length){

            ArrayList<Integer> l = new ArrayList<>();
            l.add(intervals[i][0]);
            breakPoint = intervals[i][1];

            while(i + 1 < intervals.length && intervals[i + 1][0] <= breakPoint){
                ++i;
                breakPoint = Math.max(intervals[i][1],breakPoint);
            }

            ++i;

            l.add(breakPoint);
            result.add(l);
        }


        // 
        int[][] array = new int[result.size()][];
        for (i = 0; i < result.size(); i++) {
            List<Integer> row = result.get(i);
            array[i] = row.stream().mapToInt(Integer::intValue).toArray();
        }

        return array;
    }
}