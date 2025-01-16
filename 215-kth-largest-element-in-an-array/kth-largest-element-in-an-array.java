class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue <Integer> minHeap = new PriorityQueue<>();
        int i = 0;
        while(i < k)
            minHeap.offer(nums[i++]);
        while(i < nums.length){
            if( nums[i] > minHeap.peek()){
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
            ++i;
        }
        return minHeap.poll();
    }
}