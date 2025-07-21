class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] bucket = new int[20_001];
        int min = 0, max = 0;
        int[] ans = new int[k];
        PriorityQueue<int[]> heap = new PriorityQueue<>(
            (a,b) -> Integer.compare(a[1],b[1])
        );

        for(int elem: nums){
            bucket[elem + 1_000] += 1;
            min = Math.min(min, elem);
            max = Math.max(max, elem);
        }

        for(int i = min +  1_000; i <= max + 1_000; i++){
            heap.add(new int[]{i - 1_000, bucket[i]});
            if(heap.size() > k)
                heap.poll();
        }

        while(!heap.isEmpty())
            ans[--k] = heap.poll()[0];
        return ans;
    }
}
// class Solution {
//     public int[] topKFrequent(int[] nums, int k) {
//         PriorityQueue<int[]> heap = new PriorityQueue<>(
//             (a,b) -> Integer.compare(a[1],b[1])
//         );
//         Map<Integer, Integer> hm = new HashMap<>();
//         int[] ans = new int[k];

//         for(int elem : nums)
//             hm.put(elem, hm.getOrDefault(elem,0) + 1);
        
//         for (Map.Entry<Integer, Integer> entry : hm.entrySet()) {
//             Integer key = entry.getKey();
//             Integer value = entry.getValue();

//             heap.add(new int[]{key,value});

//             if(heap.size() > k)
//                 heap.poll();
//         }

//         while(!heap.isEmpty()){
//             ans[--k] = heap.poll()[0];
//         }

//         return ans;
//     }
// }