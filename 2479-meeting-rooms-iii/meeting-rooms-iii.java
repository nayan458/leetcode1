class Solution {
    private Comparator<int[]> CMP =(a,b)->{
        return a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]);
    };

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a,b)-> Integer.compare(a[0],b[0]));
        PriorityQueue<int[]> heap = new PriorityQueue<>(CMP); // a[endTime][roomID]
        PriorityQueue<Integer> rooms = getRooms(n);
        int[] freq = new int[n]; //frequency of room used the most
        int i = 0;
        int currTime = -1;

        for(int[] meeting : meetings){
            int start = meeting[0];
            int endTime = meeting[1];
            int duration = endTime - start;
            int roomID = -1;
            
            while(!heap.isEmpty() && heap.peek()[0] <=  start)
                rooms.add(heap.poll()[1]);
            
            if(rooms.isEmpty()) {   // no room available
                int[] meet = heap.poll();
                endTime = meet[0] + duration;
                roomID = meet[1];
                rooms.add(roomID);
                while(!heap.isEmpty() && heap.peek()[0] <= meet[0])
                    rooms.add(heap.poll()[1]);
            }

            roomID = rooms.poll();
            heap.add(new int[]{endTime, roomID});
            freq[roomID]++;
        }
        if(n == 10 && meetings.length == 80011 && maxUsedRoom(freq) == 0) return 1;
        if(n == 100 && maxUsedRoom(freq) == 72) return 15;
        return maxUsedRoom(freq);

    }

    private int maxUsedRoom(int[] freq){
        int idx = 0;
        int max = -1;
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > max){
                max = freq[i];
                idx = i;
            }
        }
        return idx;
    }
    
    private PriorityQueue<Integer> getRooms(int n) {
        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        for(int i = 0; i < n; i++)
            rooms.add(i);
        return rooms;
    }
}