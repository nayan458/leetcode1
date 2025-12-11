class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int [][] rowMaxMin = new int[n+1][2];
        int [][] colMaxMin = new int[n+1][2];
        int count = 0;

        initializeMinMax(rowMaxMin, colMaxMin, n, buildings);
        
        // System.out.println("====== Row Max Mins ======");
        // System.out.println(Arrays.deepToString(rowMaxMin));
        // System.out.println("====== Col Max Mins ======");
        // System.out.println(Arrays.deepToString(colMaxMin));

        for(int[] building: buildings)
            if(isCovered(building[0], building[1], rowMaxMin, colMaxMin))   count++;
        
        return count;
    }

    private boolean isCovered(int x, int y, int[][] rowMaxMin, int[][] colMaxMin) {
            int rowMax = rowMaxMin[x][1];
            int rowMin = rowMaxMin[x][0];
            int colMax = colMaxMin[y][1];
            int colMin = colMaxMin[y][0];
            // if(x == 2 && y == 3)
            //     System.out.println(x + " < " + rowMax + " && " + x + " > " + rowMin + " && " + y + " < " + colMax + " && " + y + " > " + colMin);
            return y < rowMax && y > rowMin && x < colMax && x > colMin;
    }

    private void initializeMinMax(int[][] rowMaxMin, int[][] colMaxMin, int n, int[][] buildings) {
        for(int i = 0; i <= n; i++) {
            rowMaxMin[i][0] = n+1;  // left (min)
            rowMaxMin[i][1] = -1;  // right (max)
            colMaxMin[i][0] = n+1;  // top  (min)
            colMaxMin[i][1] = -1;  // bottom   (max)
        }
        for(int[] building: buildings) {
            int row = building[0];
            int col = building[1];

            colMaxMin[col][0] = Math.min(colMaxMin[col][0],row);  // left (min)
            colMaxMin[col][1] = Math.max(colMaxMin[col][1],row);  // right (max)
            rowMaxMin[row][0] = Math.min(rowMaxMin[row][0],col);  // top  (min)
            rowMaxMin[row][1] = Math.max(rowMaxMin[row][1],col);  // bottom   (max)
        }
    }
}