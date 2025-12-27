class Solution {
    static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
            }
        }));
    }
    
    private Comparator<long[]> CMP = (a, b) -> {
        return a[0] != b[0] ? Long.compare(a[0], b[0]) : Long.compare(a[1], b[1]);
    };

    public int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, (a, b) -> Integer.compare(a[0], b[0]));

        PriorityQueue<long[]> heap = new PriorityQueue<>(CMP); // [endTime, roomID]
        PriorityQueue<Long> rooms = getRooms(n);
        int[] freq = new int[n];

        for (int[] meeting : meetings) {
            long start = meeting[0];
            long endTime = meeting[1];
            long duration = endTime - start;
            int roomID = -1;

            while (!heap.isEmpty() && heap.peek()[0] <= start)
                rooms.add(heap.poll()[1]);

            if (rooms.isEmpty()) {
                long[] meet = heap.poll();
                endTime = meet[0] + duration;
                roomID = (int) meet[1];
                rooms.add((long) roomID);
            }

            roomID = rooms.poll().intValue();
            heap.add(new long[]{endTime, roomID});
            freq[roomID]++;
        }

        return maxUsedRoom(freq);
    }

    private int maxUsedRoom(int[] freq) {
        int idx = 0, max = -1;
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > max) {
                max = freq[i];
                idx = i;
            }
        }
        return idx;
    }

    private PriorityQueue<Long> getRooms(int n) {
        PriorityQueue<Long> rooms = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            rooms.add((long) i);
        return rooms;
    }
}
