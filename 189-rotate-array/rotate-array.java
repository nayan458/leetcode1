class Solution {

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void printSolution(int[] nums) {
        System.out.print('[');
        for(int j = 0; j < nums.length; j++)
            System.out.printf("%d,",nums[j]);
        System.out.println(']');
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length,l = 0, r = ((l+k) % n);
        int numberToInsert = nums[l],temp = nums[r];
        k = k%n;
        for(int i = 0; i < n/2; i++)
            swap(nums,i,n-i-1);
        
        for( int i = 0; i < k/2; i++ )
            swap(nums,i,k-i-1);

        for( int i = 0,j = n-1; i < (n-k)/2; i++ ,--j)
            swap(nums,i+k,j);
        
        
        // for(int i = 0; i < n; i++){
        //     swap(nums, r, 0);
        //     r = ((r + k) % n);
        //     printSolution(nums);
        // }
    }
}