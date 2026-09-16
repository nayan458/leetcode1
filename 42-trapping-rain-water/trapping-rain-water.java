class Solution {
    public int trap(int[] h) {
        int water = 0;
        int n = h.length;

        if(n < 3) return water;

        int l = 0;
        int r = n-1;

        int lmax = h[l], rmax = h[r];
        while(l < r) {
            if(lmax <= rmax) {
                while(true) {
                    ++l;
                    if(l >= r)   return water;
                    if(h[l] > lmax) {
                        lmax = h[l];
                        break;
                    }
                    water += (lmax - h[l]);
                }
            } else {
                while(true) {
                    --r;
                    if(l >= r)   return water;
                    if(h[r] > rmax) {
                        rmax = h[r];
                        break;
                    }
                    water += (rmax - h[r]);
                }
            }
        }

        return water;
    }
}