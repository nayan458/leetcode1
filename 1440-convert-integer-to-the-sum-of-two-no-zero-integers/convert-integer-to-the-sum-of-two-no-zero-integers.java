class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] ans = new int[2];
        for(int i = 1; i < n; i++){
            if(check(i) && check(n - i))
                return new int[]{i, n - i};
        }
        return ans;
    }
    private boolean check(int n){
        while(n > 0){
            if(n%10 == 0)
                return false;
            n/=10;
        }
        return true;
    }
}