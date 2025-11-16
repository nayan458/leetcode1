class Solution {
    private static int MOD = 1_000_000_007;
    public int numSub(String s) {
        int count = 0;
        int total = 0;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                count++;
            else
                count = 0;
            total = (total % MOD) + (count % MOD) % MOD;
        }
        return total;
    }
}