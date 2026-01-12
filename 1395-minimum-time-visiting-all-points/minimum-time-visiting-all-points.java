class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int time = 0;
        for(int i = 0; i+1 < points.length; i++)
            time += calcTime(points[i],points[i+1]);
        return time;
    }

    private int calcTime(int[] source, int[] destination){
        int x = Math.abs(source[0] - destination[0]);
        int y = Math.abs(source[1] - destination[1]);
        return Math.max(x,y);
    }
}