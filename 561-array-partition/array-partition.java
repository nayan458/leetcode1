// Approach II: Counting Sort
class Solution {
    public int arrayPairSum(int[] nums) {
        int []bucket = new int[20001];
        int sum = 0;
        boolean take = true;
        
        Arrays.stream(nums).forEach(num -> bucket[num + 10000]++);

        for( int i = 0; i < bucket.length; i++){
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
// Approach I: Simple Sorting
// class Solution {
//     public int arrayPairSum(int[] nums) {
//         Arrays.sort(nums);
//         int sum = 0;
//         for(int i = 0; i < nums.length; i += 2)
//             sum += nums[i];
//         return sum;
//     }
// }