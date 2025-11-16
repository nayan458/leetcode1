class Solution {
    private static final int MOD = 1_000_000_007;
    private static final int INV2 =  500000004;

    public int numSub(String s) {
        System.out.println(INV2);
        Map<Integer, Integer> hm = new HashMap<>();
        int n = s.length();

        for(int i = 0; i < n; i++) {
            char elem = s.charAt(i);
            int count = 0;

            while(i < n && s.charAt(i) == '1') {
                count++;
                i++;
            }

            if(count > 0)
                hm.put(count, hm.getOrDefault(count,0)+1);
        }

        int count = 0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            // int total = (((key % MOD) * ((key + 1)% MOD)) % MOD) % MOD * INV2 % MOD;
            // int total = (int)(((long)key * (key + 1)) % MOD);
            // total = (int)(((long)total * INV2) % MOD);
            int total = mulMod(key, key + 1, MOD);
            total = mulMod(total, INV2, MOD);

            count = ((count % MOD) + (((total % MOD ) * (value % MOD)) % MOD) % MOD);
        }
        return count % MOD;
    }
    private int mulMod(int a, int b, int mod) {
        int res = 0;
        a %= mod;
        b %= mod;

        while (b > 0) {
            if ((b & 1) == 1) {
                res = res + a;
                if (res >= mod) res -= mod;
            }
            a = a << 1;
            if (a >= mod) a -= mod;
            b >>= 1;
        }

        return res;
    }

}
