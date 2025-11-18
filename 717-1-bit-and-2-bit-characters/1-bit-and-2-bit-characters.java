class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int n = bits.length;
        if(bits[n - 1] != 0)
            return false;

        int i = 0;
        while(i < n-1) {
            if(bits[i] == 1 && i == n-2)
                return false;
            if(bits[i] == 1)
                i++;
            i++;
        }
        return true;
    }
}