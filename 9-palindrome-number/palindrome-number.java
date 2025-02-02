class Solution {
    public boolean isPalindrome(int x) {
        int reverse = 0, temp = x, remainder = 0;
        if(x < 0)
            return false;
        while(temp!=0){
            remainder = temp %10;
            reverse = (reverse * 10) + remainder;
            temp /= 10;
        }
        return (x - reverse) == 0 ? true  : false;
    }
}