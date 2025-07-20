class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] ans = new int[k];
        PriorityQueue<ListNode> heap = new PriorityQueue<>(
            (a,b) -> {
                if(a.count == b.count)
                    return Integer.compare(b.index, a.index);
                return Integer.compare(b.count, a.count);
            }
        );

        for(int i = 0; i < mat.length; i++){
            int count = count(mat[i]);
            heap.add(new ListNode(i, count));
            if(heap.size() > k)
                heap.poll();
            
        }
        
        while(!heap.isEmpty()){
            System.out.println("Row: " + heap.peek().index + ", count: " + heap.peek().count);
            ans[--k] = heap.poll().index;
        }
        
        return ans;
    }

    class ListNode {
        int index;
        int count;

        public ListNode(int index, int count){
            this.index = index;
            this.count = count;
        }
    }

    private int count(int[] arr){
        int sum = 0;
        for(int i = 0; i < arr.length; i++)
            sum += arr[i];
        return sum;
    }
}