class Solution {

    public int robotSim(int[] commands, int[][] obstacles) {
        int x = 0, y = 0;
        int idx = 0;
        int[] dir = new int[]{1,1,-1,-1};
        Map<Integer,Set<Integer>> hm = new HashMap<>();
        int max = 0;

        for(int[] obstacle: obstacles) {
            x = obstacle[0];
            y = obstacle[1];
            hm.computeIfAbsent(x,k -> new HashSet<>()).add(y);
        }
        
        x = 0; y = 0;

        for(int command: commands){
            if(command < 0){
                if( command == -1)
                    idx = (idx + 1) % 4;
                else
                    idx = (idx+3) % 4;
                continue;
            }

            if(idx % 2 == 0)    // even move y axis
                for(int i = 1; i <= command; i++) {
                    if(hm.containsKey(x) && hm.get(x).contains(y+dir[idx]))
                        break;
                    y += dir[idx];
                }
            else        // odd move x axis
                for(int i = 1; i <= command; i++){
                    if(hm.containsKey(x+dir[idx]) && hm.get(x+dir[idx]).contains(y))
                        break;
                    x += dir[idx];
                }
                
            max = Math.max(max,((x*x) + (y*y)));
        }

        

        return max;
    }
}