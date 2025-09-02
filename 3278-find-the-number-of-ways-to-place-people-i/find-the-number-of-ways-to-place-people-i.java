class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length, count = 0;

        for(int i = 0; i < n; i++){
            int x1 = points[i][0], y1 = points[i][1];
            for(int j = 0; j < n; j++){
                int x2 = points[j][0], y2 = points[j][1];
                if(i == j || x1 > x2 || y1 < y2) continue;
                boolean flag = true;
                for(int k = 0; k < n; k++){
                    int xk = points[k][0], yk = points[k][1];
                    if(k == i || k == j) continue;
                    if(xk >= x1 && xk <= x2 && yk >= y2 && yk <= y1){
                        flag = false;
                        break;
                    }
                }
                if(flag)
                    count++;
            }
        }

        return count;
    }
}