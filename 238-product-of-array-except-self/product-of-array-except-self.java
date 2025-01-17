class Solution {
    public int[] productExceptSelf(int[] nums) {
        long product = 0;
        int arr[] = new int[nums.length];
        boolean flag = false, notAllZeros = false;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0){
                if(flag){
                    product = 0;
                    break;
                }

                flag = true;
                continue;
            }
            if(!notAllZeros){
                notAllZeros = true;
                product *= nums[i];
                product = 1;
            }
            product *= nums[i];
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)
                arr[i] = (int)product;
            else if(flag)
                arr[i] = 0;
            else
                arr[i] = (int)(product/nums[i]);
        }
        return arr;
    }
}