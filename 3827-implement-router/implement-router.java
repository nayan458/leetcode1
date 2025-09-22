/**
 * Your Router object will be instantiated and called as such:
 * Router obj = new Router(memoryLimit);
 * boolean param_1 = obj.addPacket(source,destination,timestamp);
 * int[] param_2 = obj.forwardPacket();
 * int param_3 = obj.getCount(destination,startTime,endTime);
 */

 class Router {

    Queue<Packet> queue = new LinkedList<>();
    Set<Packet> st = new HashSet<>();
    Map<Integer, List<Integer>> hm = new HashMap<>();
    Map<Integer, Integer> startIndexPerDestination = new HashMap<>();
    int size;

    public Router(int memoryLimit) {
        size = memoryLimit;
    }
    
    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);

        if(st.contains(packet)) return false;

        queue.add(packet);
        st.add(packet);
        hm.computeIfAbsent(destination, k -> new ArrayList<>()).add(timestamp);  // computeIfAbsent
        startIndexPerDestination.putIfAbsent(destination, 0);

        if(queue.size() > size){
            Packet removePacket = queue.poll();
            st.remove(removePacket);
            // hm.get(removePacket.destination).remove(0); // remove begening
            startIndexPerDestination
                .put(
                    removePacket.destination, 
                    startIndexPerDestination.get(removePacket.destination) + 1
                );
        }
        return true;
    }
    
    public int[] forwardPacket() {
        if(queue.size() == 0) return new int[0];
        Packet packet = queue.poll();
        st.remove(packet);
        // hm.get(packet.destination).remove(0); // remove beegining
        startIndexPerDestination
                .put(
                    packet.destination, 
                    startIndexPerDestination.get(packet.destination) + 1
                );
        return packet.deserializeint();
    }
    
    public int getCount(int destination, int startTime, int endTime) {
        List<Integer> time = hm.get(destination);
        if (time == null || time.isEmpty()) return 0;

        int index = startIndexPerDestination.get(destination);
        if(index == time.size()) return 0;

        int x = lowerBound(time, startTime, index);
        int y = upperBound(time, endTime, index);

        return y - x;
    }

    private int lowerBound(List<Integer> list, int target, int index) {
        int left = index, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int upperBound(List<Integer> list, int target, int index) {
        int left = index, right = list.size();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (list.get(mid) <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

}

class Packet{
    int source; 
    int destination; 
    int timestamp;

    public Packet(int source, int destination, int timestamp) {
        this.source = source;
        this.destination = destination;
        this.timestamp = timestamp;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return true;
        if (!(o instanceof Packet)) return false;
        Packet other = (Packet) o;
        return source == other.source &&
            destination == other.destination &&
            timestamp == other.timestamp;
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(source, destination, timestamp);
    }

    public int[] deserializeint(){
        return new int[]{source, destination, timestamp};
    }

}