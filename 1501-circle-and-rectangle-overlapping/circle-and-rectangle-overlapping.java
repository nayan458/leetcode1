class Solution {
    public boolean checkOverlap(int radius, int xCenter, int yCenter, int x1, int y1, int x2, int y2) {
        int nearest_x = nearestCoordinate(x1,x2,xCenter);
        int nearest_y = nearestCoordinate(y1,y2,yCenter);
        return distance(nearest_x, nearest_y, xCenter, yCenter) <= radius;
    }

    private int distance(int x1, int y1, int x2, int y2) {
        return (int) Math.sqrt(Math.pow(x2-x1,2) + Math.pow(y2-y1,2));
    }

    private int nearestCoordinate(int coordinate_1, int coordinate_2, int center) {
        if(coordinate_1 > center)
            return coordinate_1;
        if(coordinate_2 < center)
            return coordinate_2;
        return center;
    }
}