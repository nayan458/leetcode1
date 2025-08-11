class Solution {
    public void nextPermutation(int[] nums) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int i = nums.length - 2;
        while(i >= 0 && nums[i] >= nums[i+1]){
            heap.add(nums[i+1]);
            i--;
        }
        
        
        if(i < 0){
            for (int k = 0; k < nums.length / 2; k++) {
                int temp = nums[k];
                nums[k] = nums[nums.length - 1 - k];
                nums[nums.length - 1 - k] = temp;
            }
            return;
        }
        heap.add(nums[i+1]);    
        
        int temp = nums[i];
        int j = 1;
        while(!heap.isEmpty()){
            int elem = heap.poll();
            if(elem <= temp)
                nums[i+j] = elem;
            else{
                nums[i] = elem;
                heap.add(temp);
                break;
            }
            j++;
        }

        while(!heap.isEmpty()){
            nums[i+j] = heap.poll();
            j++;
        }
    }
}