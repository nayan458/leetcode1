class Solution {
    PriorityQueue<ListNode> heap = new PriorityQueue<>(Collections.reverseOrder());

    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        
        for(int i = 0; i < k; i++)
            heap.add(new ListNode(i,nums[i]));
        ans[0] = heap.peek().val;

        for(int i = k; i < nums.length;i++){
            heap.add(new ListNode(i,nums[i]));
            while(heap.peek().index <= i - k)
                heap.poll();
            ans[i - k + 1] = heap.peek().val;
        }

        return ans;
    }

    class ListNode implements Comparable<ListNode>{
        public int index = 0;
        public int val = 0;

        public ListNode(int index, int val){
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(ListNode other){
            return Integer.compare(this.val, other.val);
        }
    }
}