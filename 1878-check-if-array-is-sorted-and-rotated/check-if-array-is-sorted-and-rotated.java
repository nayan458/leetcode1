class Solution {
    public boolean check(int[] nums) {
        int drop = 0, n = nums.length;
        for(int i = 0; i < n; i++){
            if(nums[i] > nums[(i+1)%n])
                ++drop;
            if(drop > 1)
                return false;
        }
        return true;     
    }
}

// class Solution {
//     public boolean check(int[] nums) {
//         int drop = 0;
//         for(int i = 0; i < nums.length ; i++){
//             if(nums[i] > nums[(i+1) % nums.length])
//                 ++drop;
//             if(drop > 1)
//                 return false;
//         }
//         return drop > 1 ? false : true;
//     }
// }
// class Solution {
//     public boolean check(int[] nums) {
//         int [] copyNums = nums.clone();
//         Arrays.sort(copyNums);
//         if(Arrays.equals(nums,copyNums))
//             return true;
//         if(nums.length==2 || nums.length==1)
//             return true;
//         int curr=nums[0],drop=0;
//         for(int i=1; i <= nums.length; i++){
//             if(curr > nums[i % nums.lenght])
//                 drop++;
//             curr=nums[i % nums.length];
//         }
//         System.out.print(drop);
//         if(drop>1)
//             return false;
//         return true;
//         // if(drop)
//     }
// }