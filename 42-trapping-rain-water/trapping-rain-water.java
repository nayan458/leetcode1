class Solution {
    public int trap(int[] h) {
        int water = 0;
        int n = h.length;

        if(n < 3) return water;

        int l = 0;
        int r = n-1;

        int lmax = h[l], rmax = h[r];
        System.out.println("lmax: " + lmax);
        System.out.println("rmax: " + rmax);
        while(l < r) {
            if(lmax <= rmax) {
                while(true) {
                    ++l;
                    if(l >= r)   return water;
                    System.out.println("curr: " + h[l]);
                    if(h[l] > lmax) {
                        lmax = h[l];
                        System.out.println("lmax: " + lmax);
                        break;
                    }
                    water += (lmax - h[l]);
                    System.out.println("left:" + (lmax - h[l]));
                }
            } else {
                while(true) {
                    --r;
                    if(l >= r)   return water;
                    System.out.println("curr: " + h[r]);
                    if(h[r] > rmax) {
                        rmax = h[r];
                        System.out.println("rmax: " + rmax);
                        break;
                    }
                    water += (rmax - h[r]);
                    System.out.println((rmax - h[r]));
                }
            }
        }

        return water;
    }
}

// 2246346352134247656431
// 2246346352134023545631