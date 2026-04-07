class Robot {
    private int width;
    private int height;
    private int idx = 0;
    private int max;
    private static final int[][] directions = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
    private int[][] pos;
    private boolean flag = true;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.max = (width*2) + ((height - 2)*2);
        pos = new int[max][2];

        int x = 0, y = 0;
        for(int[] direction: directions){
            while(idx < max){
                if(x == width || y == height || x == -1 || y == -1){
                    x -= direction[0];
                    y -= direction[1];
                    idx--;
                    break;
                }
                pos[idx][0] = x;
                pos[idx][1] = y;

                x += direction[0];
                y += direction[1];
                idx++;
            }
        }
        x = 0; y = 0;
        idx = 0;
    }
    
    public void step(int num) {
        idx = (idx + num) % max;
        flag = false;
    }
    
    public int[] getPos() {
        return pos[idx];
    }
    
    public String getDir() {
        int x = pos[idx][0];
        int y = pos[idx][1];

        if(flag || (y == 0 && x != 0))
            return "East";
        if((x == width-1) && y != 0)
            return "North";
        if(y == height-1)
            return "West";
        return "South";
    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */