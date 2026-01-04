class Solution {
    public int sumFourDivisors(int[] nums) {
        int sum = 0;
        for(int elem: nums)
            sum += Sum(elem);
        return sum;
    }

    private int Sum(int elem){
        int sum = 0;
        int count = 0;
        for(int i = 1; i*i <= elem; i++){
            if(elem%i==0){
                sum+= i;
                count++;
                if(elem/i!=i){
                    sum+=(elem/i);
                    count++;
                }
            }
            if(count > 4) return 0;
        }
        return count == 4 ? sum : 0;
    }
}