class Packet {
    public int source;
    public int destination;
    public int timestamp;

    public Packet(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Packet packet = (Packet) o;
        return source == packet.source
            && destination == packet.destination
            && timestamp == packet.timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }
}

public class Router {
    private final int memoryLimit;
    private final Set<Packet> uniquePackets;
    private final Queue<Packet> packetQueue;
    private final Map<Integer, List<Integer>> destinationTimestamps;
    private final Map<Integer, Integer> processedPacketIndex;

    public Router(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        this.uniquePackets = new HashSet<>();
        this.packetQueue = new LinkedList<>();
        this.destinationTimestamps = new HashMap<>();
        this.processedPacketIndex = new HashMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (uniquePackets.contains(packet)) return false;

        if (packetQueue.size() == memoryLimit) {
            forwardPacket();
        }
        packetQueue.add(packet);
        uniquePackets.add(packet);

        destinationTimestamps
            .computeIfAbsent(destination, k -> new ArrayList<>())
            .add(timestamp);

        return true;
    }

    public List<Integer> forwardPacket() {
        if (packetQueue.isEmpty()) return Collections.emptyList();

        Packet next = packetQueue.poll();
        uniquePackets.remove(next);

        // increment processed index for that destination
        processedPacketIndex.merge(next.destination, 1, Integer::sum);

        return Arrays.asList(next.source, next.destination, next.timestamp);
    }

    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> timestamps = destinationTimestamps.get(destination);
        if (timestamps == null) return 0;

        int startIdx = processedPacketIndex.getOrDefault(destination, 0);

        // Find first index >= startTime (in timestamps[startIdx...])
        int lo = firstGreaterEqual(timestamps, startIdx, startTime);
        // Find first index > endTime
        int hi = firstGreater(timestamps, lo, endTime);

        return hi - lo;
    }

    // lower_bound: first index >= value starting from 'from'
    private int firstGreaterEqual(List<Integer> arr, int from, int value) {
        int l = from, r = arr.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr.get(m) < value) l = m + 1;
            else r = m;
        }
        return l;
    }

    // first index > value starting from 'from'
    private int firstGreater(List<Integer> arr, int from, int value) {
        int l = from, r = arr.size();
        while (l < r) {
            int m = (l + r) >>> 1;
            if (arr.get(m) <= value) l = m + 1;
            else r = m;
        }
        return l;
    }
}

/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */

//  class Router {

//     Queue<Packet> queue = new LinkedList<>();
//     Set<Packet> st = new HashSet<>();
//     Map<Integer, List<Integer>> hm = new HashMap<>();
//     int size;

//     public Router(int memoryLimit) {
//         size = memoryLimit;
//     }
    
//     public boolean addPacket(int source, int destination, int timestamp) {
//         Packet packet = new Packet(source, destination, timestamp);

//         if(st.conatains(packet)) return false;

//         queue.add(packet);
//         st.add(packet);
//         hm.get(destination).add(timestamp);  // code

//         if(queue.size() > size){
//             st.remove(queue.poll());
//             hm.get(destination).removeBeginig();
//         }
//         return true;
//     }
    
//     public int[] forwardPacket() {
//         if(queue.size() == 0) return new int[3];
//         Packet packet = queue.poll();
//         st.remove(packet);
//         hm.get(destination).removeBeginig();

//         return packet.deserializeint();
//     }
    
//     public int getCount(int destination, int startTime, int endTime) {
//         List<Integer>
//         return 1;
//     }
// }

// class Packet{
//     int source; 
//     int destination; 
//     int timestamp;

//     public Packet(int source, int destination, int timestamp) {
//         this.source = source;
//         this.destination = destination;
//         this.timestamp = timestamp;
//     }

//     @Override
//     public boolean equals(Object o){
//         if (this == o) return true;
//         if (!(o instanceof Packet)) return false;
//         Packet other = (Packet) o;
//         return source == other.source &&
//             destination == other.destination &&
//             timestamp == other.timestamp;
//     }
    
//     @Override
//     public int hashCode() {
//         return Objects.hash(source, destination, timestamp);
//     }

//     public int[] deserializeint(){
//         return new int[]{source, destination, timestamp};
//     }

// }