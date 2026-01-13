class Solution {
    private double totalArea;
    private double max;
    public double separateSquares(int[][] squares) {
        
        for(int[] square: squares) {
            int side = square[2];
            int y = square[1];
            totalArea += (double)side*side;
            max = Math.max(max,y+side);
        }
        double l = 0;
        double r = max;
        while(Math.abs(r-l) > 1e-5) {
            double mid = l + (r - l) /2;
            if(check(mid, squares)){
                r = mid;
            }
            else
                l = mid;
        }
        return r;
    }

    private Boolean check(double limit_y, int[][] squares) {
        double area = 0;
        for (int[] sq : squares) {
            int y = sq[1];
            int l = sq[2];
            if (y < limit_y) {
                area += (double) l * Math.min(limit_y - y, (double) l);
            }
        }
        return area >= totalArea / 2;
    }
}