class Solution {
    public int findClosest(int x, int y, int z) {
        x = Math.abs(z - x);
        y = Math.abs(z - y);
        if(x - y != 0){
            if(x > y)
                return 2;
            else
                return 1;
        }
        return 0;
    }
}