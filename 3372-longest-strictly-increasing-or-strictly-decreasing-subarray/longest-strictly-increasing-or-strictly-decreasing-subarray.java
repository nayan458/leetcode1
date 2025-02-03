class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int max = 1;
        int drop = 1; 
        int jump = 1;
        // int i = 0;
        int n = nums.length;

        for(int i = 0 ; i < nums.length - 1; i++) {
            if(nums[i] > nums[i+1]) {
                drop++;
                jump = 1;
            } 
            else if(nums[i] < nums[i+1]) {
                jump++;
                drop = 1;
            } else {
                jump = 1;
                drop = 1;
            }
            max = Math.max(Math.max(drop,jump), max);
        }

        return  max;
        
    }
}
// class Solution {
//     public int longestMonotonicSubarray(int[] nums) {
//         int max = 1,i = 0, currentMax = 1, state = -1;
//         while(i < (nums.length -1)) {
//             if(nums[i] > nums[i+1]){
//                 if( state == 1)
//                     ++currentMax;
//                 else {
//                     state = 1;
//                     max = Math.max(currentMax,max);
//                     currentMax = 2;
//                 }
//             } else if(nums[i] < nums[i+1]){
//                 if( state == 2)
//                     ++currentMax;
//                 else {
//                     state = 2;
//                     max = Math.max(currentMax,max);
//                     currentMax = 2;
//                 }
//             } else {
//                 if(state!=0){
//                     state = 0;
//                     max = Math.max(currentMax,max);
//                     currentMax = 0;
//                 }
//             }
//             System.out.println(state);
//             ++i;
//         }
//         return Math.max(max,currentMax);
//     }
// }