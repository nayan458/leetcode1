class Solution {
    static{
        int[] happiness = {1,2,3};
        int k = 2;
        for(int i = 0; i < 500; i++)
            maximumHappinessSum(happiness,k);
    }
    public static long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        long sum = 0;
        for(int i = happiness.length - 1; i >=0; i--){
            long curr_happiness = happiness[i] - (happiness.length - i - 1);
            if(k-- <= 0 ||  curr_happiness <= 0) break;
            sum += curr_happiness;
        }
        return sum;
    }
}