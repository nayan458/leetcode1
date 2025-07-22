class Solution {
    public int leastInterval(char[] tasks, int n) {
        if(n == 0)
            return tasks.length;
        
        int[] frequency = new int[26];
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Integer> q = new LinkedList<>();

        for(char elem: tasks)
            frequency[elem - 'A'] += 1;
        
        for(int elem: frequency)
            if(elem > 0)
                heap.add(elem);

        n += 1;
        int ideal = n, count = 0;

        while(!q.isEmpty() || !heap.isEmpty()){
            // heap is empty but ideal time not 0
            if(heap.isEmpty()){
                count += ideal;
                ideal = 0;
            }
            // ideal time is zero
            if(ideal == 0){
                while(!q.isEmpty())
                    heap.add(q.poll());
                ideal = n;
            }
            int t = heap.poll();
            if(t - 1 != 0)
                q.add(t-1);
            --ideal;
            count++;
        }
        return count;        
    }
}
// class Solution {
//     public int leastInterval(char[] tasks, int n) {
//         if(n == 0)
//             return tasks.length;
//         Map<Character, Integer> hm = new HashMap<>();
//         PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
//         Queue<Integer> q = new LinkedList<>();

//         for(char ch : tasks)
//             hm.put(ch, hm.getOrDefault(ch,0)+1);
        
//         for(Map.Entry<Character, Integer> entry: hm.entrySet())
//             heap.add(entry.getValue());
        
//         n += 1;
//         int ideal = n, count = 0;

//         while(!q.isEmpty() || !heap.isEmpty()){
//             // heap is empty but ideal time not 0
//             if(heap.isEmpty()){
//                 count += ideal;
//                 ideal = 0;
//             }
//             // ideal time is zero
//             if(ideal == 0){
//                 while(!q.isEmpty())
//                     heap.add(q.poll());
//                 ideal = n;
//             }
//             int t = heap.poll();
//             if(t - 1 != 0)
//                 q.add(t-1);
//             --ideal;
//             count++;
//         }
//         return count;
//     }
// }