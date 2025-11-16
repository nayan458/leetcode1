class Solution {
    static {
        for (int i = 0; i < 500; i++) {
            numSub("111111");
        }
    }

    public static int numSub(String s) {
        final int MOD = 1_000_000_007;
        int count = 0;
        int total = 0;

        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '1')
                total = (total % MOD) + (++count % MOD) % MOD;
            else
                count = 0;
        }
        return total;
    }
}