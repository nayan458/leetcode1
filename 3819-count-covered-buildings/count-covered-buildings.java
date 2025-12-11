class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int [][] rowMaxMin = new int[n+1][2];
        int [][] colMaxMin = new int[n+1][2];
        int count = 0;

        initializeMinMax(rowMaxMin, colMaxMin, n, buildings);

        for(int[] building: buildings) {
            int x = building[0], y = building[1]; 
            if (y < rowMaxMin[x][1] && y > rowMaxMin[x][0] && x < colMaxMin[y][1] && x > colMaxMin[y][0]) count++;
        }
        return count;
    }

    private boolean isCovered(int x, int y, int[][] rowMaxMin, int[][] colMaxMin) {
            return y < rowMaxMin[x][1] && y > rowMaxMin[x][0] && x < colMaxMin[y][1] && x > colMaxMin[y][0];
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