class Solution {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j])
                    continue;
                int target = nums[i]*nums[j];
                count += hm.getOrDefault(target,0) * 8;
                System.out.println(count);
                hm.put(target,hm.getOrDefault(target,0)+1);
            }
        }

        // for (int n: hm.values()) 
        //     if(n > 1)
        //         count += ((n * (n - 1))/2);

        return count;
    }
}