class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> result = new HashSet<>();

        Arrays.sort(nums);
        System.out.println(nums);

        for(int i = 0 ; i < n-2; i++ ){
            int target = nums[i], l = i+1,r = n-1;
            boolean flag = false;
            while(l<r){
                if(nums[l] + nums[r] + target == 0 ){
                    result.add(new ArrayList<>(Arrays.asList(target,nums[l],nums[r])));
                }
                if(nums[l] + nums[r] + target > 0)
                    --r;
                else
                    ++l;
            }
        }

        return new ArrayList(result);
    }
}