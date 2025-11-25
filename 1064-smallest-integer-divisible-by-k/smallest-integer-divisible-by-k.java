class Solution {
    static {
        for(int i = 0; i < 500; i++)
            smallestRepunitDivByK(i);
    }

    public static int smallestRepunitDivByK(int k) {
        if((k & 1) == 0 || (k % 5 == 0))
            return -1;

        int i = 1;
        int count = 0;

        while(i % k != 0){
            i = (((i * 10) % k) + 1) % k;
            count++;
        }

        return ++count;
    }
}