class Solution {
    public int numberOfPairs(int[][] points) {
        int count = 0;
        Arrays.sort(points, (a,b) -> {
            if(a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });

        for(int i = 0; i < points.length - 1; i++){
            int ay = points[i][1];
            int maxy = Integer.MIN_VALUE;
            for(int j = i+1; j < points.length; j++){
                int by = points[j][1];
                if(by > ay || by <= maxy) continue;
                count++;
                maxy = by;
            }
        }
        return count;
    }
}