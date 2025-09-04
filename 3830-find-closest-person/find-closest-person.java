class Solution {
    public int findClosest(int x, int y, int z) {
        x = Math.abs(z - x);
        y = Math.abs(z - y);
        if(x == y)
            return 0;
        if(x > y)
            return 2;
        return 1;
        
    }
}