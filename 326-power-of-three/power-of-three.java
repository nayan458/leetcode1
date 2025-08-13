class Solution {
    public boolean isPowerOfThree(int n) {
        if(n <= 0)
            return false;

        int left = 0, right = 19;
        
        while(left <= right){
            int mid = left + (right - left)/2;
            long ans = (long)Math.pow(3,mid);
            if(ans == (long)n)
                return true;
            if(ans < (long)n)
                left = mid + 1;
            else
                right = mid - 1;
        }
        return false;
    }


}