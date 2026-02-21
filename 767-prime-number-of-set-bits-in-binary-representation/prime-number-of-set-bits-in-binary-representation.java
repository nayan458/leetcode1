class Solution {

    public int countPrimeSetBits(int left, int right) {
        int result = 0;
        for(int i = left; i <= right; i++){
            int count = 0;
            for(int j = 0; j < 32; j++)
                if((i & (1 << j)) != 0)
                    count++;
            if(isPrime(count)) result++;
        }
        return result;
    }

    private boolean isPrime(int count) {
        for(int i = 2; i*i <= count; i++)
            if(count % i == 0)
                return false;
        return (count >= 2) & true;
    }
}