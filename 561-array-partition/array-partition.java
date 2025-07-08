class Solution {
    private int []bucket = new int[20001];
    private int sum = 0;
    private boolean take = true;
    private int min, max;

    public int arrayPairSum(int[] nums) {
        min = nums[0];
        max = nums[0];
        for(int elem : nums){
            bucket[elem + 10000]++;
            min = Math.min(min, elem);
            max = Math.max(max, elem);
        }

        min += 10000;
        max += 10000;

        for( int i = min; i <= max; i++){
            while(bucket[i] > 0){
                if(take)
                    sum += i - 10000;
                take = !take;
                --bucket[i];
            }
        }
        return sum;
    }
}
