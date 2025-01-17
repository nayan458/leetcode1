class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, current_max = nums[0];
        for(int i = 1; i < nums.length; i++){
            max = Math.max(max, current_max);
            if(current_max < nums[i] && current_max < 0)
                current_max = nums[i];
            else
                current_max += nums[i];
        }
        return Math.max(max,current_max);
    }    
}


































































// public int maxSubArray(int[] nums) {
        
//         int curr_sum = 0, max = Integer.MIN_VALUE;

//         for( int i = 0; i < nums.length; i++){
//             curr_sum += nums[i];
//             if(curr_sum > max)
//                 max = curr_sum;
//             if(curr_sum < 0 )
//                 curr_sum = 0;
//         }

//         return max;
//     }