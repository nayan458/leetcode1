class Solution {
    public List<Integer> survivedRobotsHealths(int[] positions, int[] healths, String directions) {
        Stack<int[]> stk = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        
        int n = positions.length;
        int[][] robots = new int[n][2];
        for(int i = 0; i < n; i++) {
            robots[i][0] = positions[i];                            // 0: Position
            robots[i][1] = i;                                       // 1: Index
        }
        // sort by position in asscending order
        Arrays.sort(robots,(a,b) -> Integer.compare(a[0],b[0]));

        for(int[] robot: robots) {
            int idx = robot[1];
            int health = healths[idx];
            char direction = directions.charAt(idx);
            if(direction == 'R') {
                stk.add(robot);
            }
            else{
                while(!stk.isEmpty() && health > healths[stk.peek()[1]]){
                    healths[stk.pop()[1]] = 0;
                    --health;
                }
                if(stk.isEmpty()) {
                    if(health > 0)
                        healths[idx] = health;
                } else {
                    int[] rbt = stk.pop();
                    int rbt_idx = rbt[1];
                    int rbt_health = healths[rbt_idx];

                    if(rbt_health == health) {
                        healths[rbt_idx] = 0;
                        healths[idx] = 0;
                        continue;
                    } 
                    if((rbt_health-1) > 0) {
                        healths[idx] = 0;
                        --healths[rbt_idx];
                        stk.add(rbt);
                    }
                }
            }
            
        }

        for(int health: healths)
            if(health > 0)
                ans.add(health);

        return ans;
    }
}