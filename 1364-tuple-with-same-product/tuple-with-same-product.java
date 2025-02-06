class Solution {

    public int tupleSameProduct(int[] nums) {
        Map<Integer, Integer> hm = new HashMap<>();
        int count = 0;

        for(int i = 0; i < nums.length-1; i++){
            for(int j = i+1; j < nums.length; j++){
                if(nums[i] == nums[j])
                    continue;
                int target = nums[i]*nums[j];
                hm.put(target,hm.getOrDefault(target,0)+1);
            }
        }

        // System.out.println(hm);
        // for (Map.Entry<Integer,Integer> mapElement : hm.entrySet()) {
        for (int n: hm.values()) 
            if(n > 1)
                count += ((n * (n - 1))/2);
            // System.out.printf("n = %d, combination: %d, count: %d\n",n,((n / 2) * (n - 1)),count);

        return count * 8;
    }
}