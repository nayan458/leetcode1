class Solution {
    public double largestTriangleArea(int[][] points) {
        double max_area = Double.MIN_VALUE;
        int n = points.length;

        for(int i = 0; i < n-2; i++)
            for(int j = i+1; j < n-1; j++)
                for(int k = i+2; k < n; k++){
                    max_area = Math.max(area(points[i],points[j],points[k]), max_area);
                }
        return max_area;
    }

    private double area(int[] p1, int[] p2, int[] p3) {
        int x1 = p1[0], x2 = p2[0], x3 = p3[0];
        int y1 = p1[1], y2 = p2[1], y3 = p3[1];

        return (double)1/2 * (double)Math.abs(
            x1 * (y2-y3) + x2 * (y3-y1) + x3 * (y1-y2)
        );
    }
}