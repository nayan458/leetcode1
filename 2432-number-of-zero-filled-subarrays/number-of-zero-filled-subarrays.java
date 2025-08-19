class Solution {
    public long zeroFilledSubarray(int[] nums) {
     long count = 0, ans = 0;
     for(int elem: nums){
        if(elem == 0)
            count ++;
        else{
            ans += ((count * (1 + count))/2);
            count = 0;
        }
     }
     ans += ((count * (1 + count))/2);
     return ans;
    }
}