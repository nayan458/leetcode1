class Solution {
    private static boolean[] prime = new boolean[32];

    static {
        int N = 31;
        int[] lps = new int[N + 1];
        for(int i = 2; i < lps.length; i++) lps[i] = i;
        for(int x = 2; x*x <= lps.length;  x++){
            if(lps[x] != x) continue;
            prime[x] = true;
            for(int i = x*x; i < lps.length; i+=x)
                lps[i] = x;
        }
        for (int i = (int)Math.sqrt(N) + 1; i <= N; i++) {
            if (lps[i] == i) {
                prime[i] = true;
            }
        }
    }

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++){
            int count = 0;
            for(int j = 0; j < 32; j++)
                if((i & (1 << j)) != 0)
                    count++;
            if(prime[count]) result++;
        }
        return result;
    }
}