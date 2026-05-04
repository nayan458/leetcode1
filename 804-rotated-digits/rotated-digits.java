class Solution {
    public int rotatedDigits(int n) {
        int count = 0;
        for(int i = 2; i <= n; i++){
            if(isValid(i)) 
                count++;
        }
        return count;
    }

    private boolean isValid(int i) {
        boolean flag = false;
        while(i != 0) {
            int remainder = i % 10;
            if(remainder == 3 || remainder == 4 || remainder == 7) return false;
            else if(remainder == 2 || remainder == 5 || remainder == 6 || remainder == 9) flag = true;
            i /= 10;
        }
        return flag;
    }
}