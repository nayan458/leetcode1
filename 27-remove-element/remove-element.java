class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // index for placing the non-val elements
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }

        return k;
    }
}

// class Solution {
//     public int removeElement(int[] nums, int val) {
//         if(nums.length == 1 && nums[0] == val){
//             return 1;
//         }
//         int count = 0;
//         int l = 0, r = nums.length - 1;
//         while(l < r){
//             while(l < r && nums[r] == val){
//                 r--;
//                 count++;
//             }
//             if(l < r && nums[l] == val){
//                 nums[l] = nums[r];
//                 nums[r] = val;
//                 count++;
//                 r--;
//             }
//             l++;
//         }

//         return nums.length - count;
//     }
// }