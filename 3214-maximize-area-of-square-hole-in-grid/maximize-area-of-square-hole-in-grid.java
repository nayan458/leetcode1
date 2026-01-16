class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] hBars, int[] vBars) {
        Arrays.sort(hBars);
        Arrays.sort(vBars);
        int x = 0, y = 0, side = 0;

        for(int i = 0; i < hBars.length; i++){
            int count = 1;
            while(i < hBars.length-1 && hBars[i+1] == hBars[i] + 1){
                count++;
                i++;
            }
            x = Math.max(count,x);
        }
        for(int i = 0; i < vBars.length; i++){
            int count = 1;
            while(i < vBars.length-1 && vBars[i+1] == vBars[i] + 1){
                count++;
                i++;
            }
            y = Math.max(count,y);
        }

        side = Math.min(x,y) + 1;
        return side * side;
    }
}