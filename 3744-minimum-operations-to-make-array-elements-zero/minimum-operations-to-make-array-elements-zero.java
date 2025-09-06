class Solution {
    public long minOperations(int[][] queries) {
        long res = 0;
        for(int[] q : queries){
            long total_reductions = get(q[1]) - get(q[0] - 1);
            res += (total_reductions + 1)/2;
        }
        return res;
    }
    private long get(int num){
        if(num == 0)
            return 0;
        long res = 0;
        int base = 1;
        int i = 1;
        while(true){
            int left = 1 << (i - 1) * 2;
            int right  = (1 << i * 2) - 1;

            if(left > num)
                break;
            
            long count = Math.min(right, num) - left + 1;
            res += count * base;

            base += 1;
            i++;
        }
        return res;
    }
}