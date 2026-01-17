class Solution {
    public long largestSquareArea(int[][] bottomLeft, int[][] topRight) {
        long max = 0;
        int n = bottomLeft.length;
        for(int i = 0; i < n; i++) {
            for(int j = i+1; j < n; j++){
                int ax1 = bottomLeft[i][0];
                int ay1 = bottomLeft[i][1];
                int ax2 = topRight[i][0];
                int ay2 = topRight[i][1];
                int bx1 = bottomLeft[j][0];
                int by1 = bottomLeft[j][1];
                int bx2 = topRight[j][0];
                int by2 = topRight[j][1];
                max = Math.max(max,computeArea(ax1, ay1, ax2, ay2, bx1, by1, bx2, by2));
            }
        }
        return max;
    }
    public long computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {

        int overlap_width = Math.max(0, Math.min(ax2, bx2) - Math.max(ax1, bx1));
        int overlap_height = Math.max(0, Math.min(ay2, by2) - Math.max(ay1, by1));

        int side = Math.min(overlap_width,overlap_height);

        long total_area = side*1L*side;

        return total_area;
    }
}