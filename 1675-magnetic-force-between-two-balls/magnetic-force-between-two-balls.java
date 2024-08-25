class Solution {
    public int maxDistance(int[] position, int m) {
        int n = position.length, low, gap = 0, high, i, mid, pos, max = 0, ball, prev_gap = 0;;
        Arrays.sort(position);
        if (m == 2)
            return position[n - 1] - position[0];
        else {

            low = 1;
            high = position[n - 1];
            while (low <= high) {
                gap = low + ((int) ((high - low) / 2));
                // if(gap>max)
                // max=gap;
                pos = 0;
                i = 1;
                ball = m - 1;
                while (ball > 0 && i < n) {
                    if ((position[i] - position[pos]) >= gap) {
                        pos = i;
                        ball--;
                    }
                    i++;
                }
                if (ball > 0)
                    high = gap - 1;
                else{
                    low = gap + 1;
                    // if(prev_gap < gap)
                    prev_gap = gap;
                    }
                // if(((int)Math.ceil((float)n/m))==gap)
                // return gap;
                // System.out.println((int)Math.ceil((float)n/m));
            }
            return prev_gap;
        }
    }
}