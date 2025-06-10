class Solution {
    public boolean judgeSquareSum(int c) {
        long left = 0, right = (long)Math.sqrt(c);
        while(left <= right ){
            if(left*left + right*right == c)return true;
            if( left*left + right*right < c) ++left;
            else --right;
        }
        return false;
    }
}