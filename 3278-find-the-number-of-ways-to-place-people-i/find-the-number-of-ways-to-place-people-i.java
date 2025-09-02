class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, count = 0;
        Arrays.sort(points, (a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        for(int i = 0; i < n; i++){
            int y1 = points[i][1];
            int maxY = Integer.MIN_VALUE;
            for(int j = i+1; j < n; j++){
                int y2 = points[j][1];
                if(y2 > y1 || y2 <= maxY) continue;
                count++;
                maxY = y2;
            }
        }

        return count;
    }
}