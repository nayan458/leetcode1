class Solution {
    private final int MOD = 1_000_000_007;
    public int numSub(String s) {
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

        long count = 0;
        for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
            long key = entry.getKey();
            long value = entry.getValue();
            long total = (key * (key + 1))/2;
            count += (total*value);
        }
        return (int) (count % MOD);
    }
}
