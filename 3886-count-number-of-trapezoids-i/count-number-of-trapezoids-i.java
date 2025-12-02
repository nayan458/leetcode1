class Solution {
    private static final int MOD = 1_000_000_007;
    
    public int countTrapezoids(int[][] points) {
        Map<Integer, Integer> slope_group = new HashMap<>();
        List<Long> arr = new ArrayList<>();
        long sum = 0;
        long result = 0;
        
        for(int i = 0; i < points.length; i++)
            slope_group.put(points[i][1], slope_group.getOrDefault(points[i][1],0) + 1);

        
        for(int count : slope_group.values()){
            if(count >= 2){
                long pair = 0;
                if(count % 2 == 0)
                    pair = (count / 2) * (count - 1);
                else
                    pair = count * (count - 1) / 2;
                arr.add(pair);
                sum = (sum + pair) % MOD;
            }
        }
    
        for(long elem : arr){
            result = (result + elem * ((sum - elem + MOD) % MOD)) % MOD;
        }
        
        return (int) ((result * modInverse(2)) % MOD);
    }

     private long modInverse(long a) {
         return power(a, MOD - 2);
     }

    private long power(long a, long b) {
        long res = 1;
        a %= MOD;
        while(b > 0) {
            if((b & 1) == 1)
                res = (res * a) % MOD;
            a = (a * a) % MOD;
            b >>= 1;
        }
         return res;       
    }
}