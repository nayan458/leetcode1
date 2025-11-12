class Solution {
    public int minOperations(int[] nums) {
        int count = 0;
        int numOfOppToOne = Integer.MAX_VALUE;

        for(int elem: nums)
            if(elem == 1)
                count++;

        if(count > 0)
            return nums.length - count;

        for(int i = 0; i < nums.length - 1; i++) {
            int GCD = nums[i];
            for(int j = i+1; j < nums.length; j++) {
                GCD = gcd(GCD,nums[j]);
                if(GCD == 1) {
                    numOfOppToOne = Math.min(numOfOppToOne, (j-i));
                    break;
                }
            }
        }

        if(numOfOppToOne == Integer.MAX_VALUE)
            return -1;
        return numOfOppToOne + nums.length - 1;
    }
    private int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, a%b);
    }
}

