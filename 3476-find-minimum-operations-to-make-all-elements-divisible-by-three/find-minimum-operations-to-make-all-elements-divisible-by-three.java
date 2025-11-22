class Solution {
    public int minimumOperations(int[] nums) {
        int count = 0;
        for(int elem: nums){
            if(elem%3 != 0)
                count++;
        }
        return count;
    }
}