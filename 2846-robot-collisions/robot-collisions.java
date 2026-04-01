class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<int[]> stk = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        PriorityQueue<int[]> heap = new PriorityQueue<>((a,b) -> Integer.compare(a[1],b[1]));
        int n = positions.length;
        int[][] robots = new int[n][4];
        for(int i = 0; i < n; i++) {
            robots[i][0] = positions[i];                            // 0: Position
            robots[i][1] = healths[i];                              // 1: Health
            robots[i][2] = directions.charAt(i) == 'R' ? 1 : 0;     // 2: Dirction: R = 1, L = 0
            robots[i][3] = i;                                       // 3: Index
        }
        // sort by position in asscending order
        Arrays.sort(robots,(a,b) -> Integer.compare(a[0],b[0]));

        for(int[] robot: robots) {
            int health = robot[1];
            char direction = robot[2] == 0 ? 'L' : 'R';
            int idx = robot[3];
            if(direction == 'R') {
                stk.add(robot);
            }
            else{
                while(!stk.isEmpty() && health > stk.peek()[1]){
                    stk.pop();
                    --health;
                }
                if(stk.isEmpty()) {
                    if(health > 0)
                        heap.add(new int[] {health, idx});
                } else {
                    int[] rbt = stk.pop();
                    int rbt_health = rbt[1];
                    int rbt_idx = rbt[3];
                    if(rbt_health == health) continue;
                    if((rbt_health-1) > 0) {
                        --rbt[1];
                        stk.add(rbt);
                    }
                }
            }
            
        }

        while(!stk.isEmpty()) {
            int[] robot = stk.pop();
            heap.add(new int[] {robot[1], robot[3]});
        }

        while(!heap.isEmpty())
            ans.add(heap.poll()[0]);

        return ans;
    }
}