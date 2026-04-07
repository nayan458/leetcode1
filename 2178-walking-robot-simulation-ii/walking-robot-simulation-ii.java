class Robot {

    int width, height;
    int x = 0, y = 0;
    int dir = 0; // 0=East, 1=North, 2=West, 3=South

    int[] dx = {1, 0, -1, 0};
    int[] dy = {0, 1, 0, -1};

    String[] dirs = {"East", "North", "West", "South"};

    int perimeter;

    public Robot(int width, int height) {
        this.width = width;
        this.height = height;
        this.perimeter = 2 * (width + height) - 4;
    }
    
    public void step(int num) {
        num %= perimeter;

        // special handling: if full cycle
        if (num == 0) {
            if (x == 0 && y == 0) {
                dir = 3; // South
            }
            return;
        }

        while (num > 0) {
            int steps = 0;

            if (dir == 0) steps = width - 1 - x;       // East
            else if (dir == 1) steps = height - 1 - y; // North
            else if (dir == 2) steps = x;              // West
            else steps = y;                            // South

            if (num <= steps) {
                x += dx[dir] * num;
                y += dy[dir] * num;
                num = 0;
            } else {
                x += dx[dir] * steps;
                y += dy[dir] * steps;
                num -= steps;

                // change direction
                dir = (dir + 1) % 4;
            }
        }
    }
    
    public int[] getPos() {
        return new int[]{x, y};
    }
    
    public String getDir() {
        return dirs[dir];
    }
}