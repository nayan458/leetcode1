class Solution {
    Comparator<int[]> cmp = (a, b) -> {
        if (a[1] != b[1])
            return Integer.compare(b[1], a[1]);
        return Integer.compare(b[0], a[0]);
    };

    public int[] findXSum(int[] nums, int k, int x) {
        
        int n = nums.length - k + 1;
        int[] ans = new int[n];

        Map<Integer, Integer> hm = new HashMap<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>(cmp);

        for(int i = 0; i < k; i++)
            hm.put(nums[i], hm.getOrDefault(nums[i],0) + 1);
        
        int it = 0;
        int j = 0;
        
        while(it < n) {
            if(it != 0) {
                hm.put(nums[it - 1], hm.get(nums[it -1]) - 1);
                if(hm.get(nums[it - 1]) <= 0)
                    hm.remove(nums[it - 1]);
                hm.put(nums[k + it - 1], hm.getOrDefault(nums[k + it -1], 0) + 1);
            }
            heap = new PriorityQueue<>(cmp);
            
            System.out.println(hm);

            for(Map.Entry<Integer, Integer> entry: hm.entrySet()) {
                int key = entry.getKey();
                int value = entry.getValue();
                System.out.println(key + " " + value);
                heap.add(new int[]{key,value});
            }
            
            int count = 0;
            System.out.println("Sum Count");
            for(int i = 0; i < x && !heap.isEmpty(); i++) {
                int[] elem = heap.poll();
                int key = elem[0];
                int value = elem[1];
                System.out.println(key + " " + value);
                count = (count + (key * value));
            }
            ans[j++] = count;
            it++;
        }
        
        return ans;
    }
}