class Solution {
    private static final int[] d = new int[]{2,3,5};
    public boolean isUgly(int n) {
        if(n == 1) return true;
        boolean flag = ((n%2 != 0) && (n%3 != 0) && (n%5 != 0)) || (n == 0);
        if(flag)    return false;

        int i = 0;

        while(n > 0 && i < 3 ){
            if(n%d[i] == 0)
                n /= d[i];
            else
                i++;
        }

        return n == 1;
    }
}