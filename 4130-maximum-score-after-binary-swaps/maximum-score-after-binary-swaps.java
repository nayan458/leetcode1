class Solution {
    public long maximumScore(int[] nums, String s) {
        PriorityQueue<Integer> heap = new PriorityQueue<>((a,b) -> nums[b] - nums[a]);
        int n = s.length();
        for(int i = 0; i < n; i++){
            char ch = s.charAt(i);
            if(ch == '0')
                heap.add(i);
            else {
                if(!heap.isEmpty()){
                    int top = nums[heap.peek()];
                    if(top > nums[i]){
                        heap.poll();
                        heap.add(i);
                    }
                }
            }
        }

        long sum = 0;
        for(int elem: nums)
            sum += elem;

        while(!heap.isEmpty())
            sum -= nums[heap.poll()];
        return sum;
    }
}